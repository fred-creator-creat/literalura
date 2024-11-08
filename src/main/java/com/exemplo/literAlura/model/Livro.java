package com.exemplo.literAlura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)  // Validação para garantir que o título não seja nulo e tenha tamanho máximo de 255 caracteres
    private String titulo;

    @NotNull
    @Size(min = 1, max = 255)  // Validação para garantir que o autor não seja nulo e tenha tamanho máximo de 255 caracteres
    private String autor;

    @NotNull
    @Size(min = 1, max = 50)  // Validação para garantir que o idioma não seja nulo e tenha tamanho máximo de 50 caracteres
    private String idioma;

    private Integer downloads;  // Mantido Integer para permitir valor nulo

    // Construtor padrão (para JPA)
    public Livro() {
    }

    // Construtor com todos os campos (útil para criar instâncias facilmente)
    public Livro(String titulo, String autor, String idioma, Integer downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    // Sobrescrevendo equals() e hashCode() para garantir que a comparação de objetos seja baseada no id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Método toString() para exibir o livro de forma mais legível
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", downloads=" + downloads +
                '}';
    }
}