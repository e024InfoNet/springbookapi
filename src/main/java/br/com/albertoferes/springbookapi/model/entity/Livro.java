package br.com.albertoferes.springbookapi.model.entity;

import br.com.albertoferes.springbookapi.api.resource.dto.LivroDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    private Livro(LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.titulo = livroDTO.getTitulo();
        this.autor = livroDTO.getAutor();
        this.isbn = livroDTO.getIsbn();
    }

    public static Livro criar(LivroDTO livroDTO) {
        return new Livro(livroDTO);
    }

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public Livro setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Livro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public Livro setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id.equals(livro.id) && titulo.equals(livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
