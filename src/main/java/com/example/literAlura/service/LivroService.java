package com.example.literAlura.service;

import com.example.literAlura.repository.LivroRepository;
import com.exemplo.literAlura.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Salvar um livro no banco de dados
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // Listar todos os livros
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    // Buscar livro pelo título, com integração com a API externa (Gutendex)
    public Livro buscarLivroPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gutendex.com/books/?search=" + titulo;
        
        // Fazendo a requisição e obtendo a resposta
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        
        if (response != null && response.getResults().length > 0) {
            // Pegando o primeiro resultado da resposta da API
            Livro livro = new Livro();
            livro.setTitulo(response.getResults()[0].getTitle());
            livro.setAutor(response.getResults()[0].getAuthor());
            livro.setIdioma(response.getResults()[0].getLanguage());
            livro.setDownloads(response.getResults()[0].getDownloads());
            return livro;
        }
        return null; // Retorna null se não encontrar nenhum livro
    }

    // Métodos para buscar livros no banco de dados usando o LivroRepository
    public Optional<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);  // Busca livro por título no banco
    }

    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutor(autor);  // Busca livros por autor no banco
    }

    public List<Livro> buscarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);  // Busca livros por idioma no banco
    }

    public List<Livro> buscarLivrosComDownloads(Integer minDownloads) {
        return livroRepository.findByDownloadsGreaterThan(minDownloads);  // Busca livros com downloads maiores que o valor fornecido
    }

    public List<Livro> buscarLivrosPorDownloadsEIdioma(Integer minDownloads, String idioma) {
        return livroRepository.findLivrosByDownloadsGreaterThanAndIdioma(minDownloads, idioma);  // Busca livros com downloads maiores e no idioma fornecido
    }

    public List<Livro> buscarLivrosPorTituloParcial(String titulo) {
        return livroRepository.findLivrosByTituloContaining(titulo);  // Busca livros que contenham o título informado
    }

    // Classe interna para mapear a resposta da API Gutendex
    public static class GutendexResponse {
        private Result[] results;

        public Result[] getResults() {
            return results;
        }

        public void setResults(Result[] results) {
            this.results = results;
        }
    }

    // Classe interna para mapear cada item do resultado retornado pela API
    public static class Result {
        private String title;
        private String author;
        private String language;
        private int downloads;

        // Getters e Setters
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        public String getLanguage() { return language; }
        public void setLanguage(String language) { this.language = language; }
        public int getDownloads() { return downloads; }
        public void setDownloads(int downloads) { this.downloads = downloads; }
    }
}