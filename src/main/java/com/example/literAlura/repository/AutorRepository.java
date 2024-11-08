package com.example.literAlura.repository;

import com.exemplo.literAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Método para buscar autores por ano de nascimento
    List<Autor> findByAnoNascimento(int anoNascimento);

    // Método para buscar autor por nome (não sensível a maiúsculas/minúsculas)
    List<Autor> findByNomeContainingIgnoreCase(String nome);
}