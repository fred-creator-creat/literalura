package com.example.literAlura.controller;

import com.example.literAlura.service.AutorService;
import com.exemplo.literAlura.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Endpoint para listar todos os autores
    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.listarAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    // Endpoint para buscar autores por ano de nascimento
    @GetMapping("/anoNascimento")
    public ResponseEntity<List<Autor>> listarPorAnoNascimento(@RequestParam int anoNascimento) {
        List<Autor> autores = autorService.listarAutoresPorAnoNascimento(anoNascimento);
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    // Endpoint para buscar autor por nome
    @GetMapping("/buscar")
    public ResponseEntity<List<Autor>> buscarPorNome(@RequestParam String nome) {
        List<Autor> autores = autorService.buscarAutorPorNome(nome);
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    // Endpoint para adicionar um novo autor
    @PostMapping
    public ResponseEntity<Autor> adicionar(@RequestBody Autor autor) {
        Autor autorSalvo = autorService.salvarAutor(autor);
        return new ResponseEntity<>(autorSalvo, HttpStatus.CREATED);
    }
}
