package com.example.literAlura.service;

import com.example.literAlura.repository.AutorRepository;
import com.exemplo.literAlura.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Método para listar todos os autores
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // Método para listar autores por ano de nascimento
    public List<Autor> listarAutoresPorAnoNascimento(int anoNascimento) {
        return autorRepository.findByAnoNascimento(anoNascimento);
    }

    // Método para buscar autores por nome (sem diferenciar maiúsculas e minúsculas)
    public List<Autor> buscarAutorPorNome(String nome) {
        return autorRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Método para salvar um novo autor
    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}