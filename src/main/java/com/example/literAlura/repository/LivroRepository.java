package com.example.literAlura.repository;

import com.exemplo.literAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Método para buscar livro pelo título
    Optional<Livro> findByTitulo(String titulo);

    // Método para buscar livros por autor
    List<Livro> findByAutor(String autor);

    // Método para buscar livros por idioma
    List<Livro> findByIdioma(String idioma);

    // Método para buscar livros com mais de um número de downloads
    List<Livro> findByDownloadsGreaterThan(Integer downloads);

    // Usando @Query para uma consulta personalizada com JPQL
    @Query("SELECT l FROM Livro l WHERE l.downloads > :minDownloads AND l.idioma = :idioma")
    List<Livro> findLivrosByDownloadsGreaterThanAndIdioma(
        @Param("minDownloads") Integer minDownloads, 
        @Param("idioma") String idioma
    );

    // Usando @Query para buscar livros que correspondem a um padrão no título
    @Query("SELECT l FROM Livro l WHERE l.titulo LIKE %:titulo%")
    List<Livro> findLivrosByTituloContaining(@Param("titulo") String titulo);
}