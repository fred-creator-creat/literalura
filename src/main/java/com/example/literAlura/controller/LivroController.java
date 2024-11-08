package com.example.literAlura.controller;

import com.example.literAlura.service.LivroService;
import com.exemplo.literAlura.model.Livro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@Validated  // Garante que as validações de BeanValidation sejam realizadas
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Endpoint para adicionar um livro
    @PostMapping
    public ResponseEntity<Livro> adicionar(@Valid @RequestBody Livro livro) {
        // Aqui estamos usando o @Valid para garantir que o Livro seja validado antes de ser salvo
        Livro livroSalvo = livroService.salvar(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);  // Retorna um 201 (created) após salvar
    }

    // Endpoint para listar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.listar();
        return new ResponseEntity<>(livros, HttpStatus.OK);  // Retorna todos os livros com status 200 (OK)
    }

    // Endpoint para buscar um livro por título (busca na API externa)
    @GetMapping("/buscar")
    public ResponseEntity<Livro> buscar(@RequestParam String titulo) {
        Livro livro = livroService.buscarLivroPorTitulo(titulo);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);  // Retorna o livro encontrado
        }
        // Se não encontrar, retornar um erro 404
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
    }

    // Endpoint para buscar um livro no banco por título (busca no banco de dados)
    @GetMapping("/buscar/banco")
    public ResponseEntity<Livro> buscarNoBanco(@RequestParam String titulo) {
        Optional<Livro> livro = livroService.buscarPorTitulo(titulo);
        if (livro.isPresent()) {
            return new ResponseEntity<>(livro.get(), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado no banco de dados");
    }

    // Endpoint para buscar livros por autor
    @GetMapping("/buscar/autor")
    public ResponseEntity<List<Livro>> buscarPorAutor(@RequestParam String autor) {
        List<Livro> livros = livroService.buscarPorAutor(autor);
        if (livros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro encontrado para o autor " + autor);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    // Endpoint para buscar livros por idioma
    @GetMapping("/buscar/idioma")
    public ResponseEntity<List<Livro>> buscarPorIdioma(@RequestParam String idioma) {
        List<Livro> livros = livroService.buscarPorIdioma(idioma);
        if (livros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro encontrado para o idioma " + idioma);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    // Endpoint para buscar livros com downloads maiores que um valor
    @GetMapping("/buscar/downloads")
    public ResponseEntity<List<Livro>> buscarPorDownloads(@RequestParam Integer minDownloads) {
        List<Livro> livros = livroService.buscarLivrosComDownloads(minDownloads);
        if (livros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro encontrado com downloads maiores que " + minDownloads);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    // Endpoint para buscar livros com downloads maiores e no idioma específico
    @GetMapping("/buscar/downloads-idioma")
    public ResponseEntity<List<Livro>> buscarLivrosPorDownloadsEIdioma(@RequestParam Integer minDownloads, @RequestParam String idioma) {
        List<Livro> livros = livroService.buscarLivrosPorDownloadsEIdioma(minDownloads, idioma);
        if (livros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro encontrado com downloads maiores que " + minDownloads + " e no idioma " + idioma);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    // Endpoint para buscar livros com título parcial
    @GetMapping("/buscar/titulo-parcial")
    public ResponseEntity<List<Livro>> buscarLivrosPorTituloParcial(@RequestParam String titulo) {
        List<Livro> livros = livroService.buscarLivrosPorTituloParcial(titulo);
        if (livros.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum livro encontrado com o título " + titulo);
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
}