package br.com.albertoferes.springbookapi.api.resource.dto;

import br.com.albertoferes.springbookapi.model.entity.Livro;

public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;

    public LivroDTO(Long id, String titulo, String autor, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    private LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.isbn = livro.getIsbn();
    }

    public static LivroDTO criar(Livro livro) {
        return new LivroDTO(livro);
    }

    public LivroDTO() {
    }

    public Long getId() {
        return id;
    }

    public LivroDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public LivroDTO setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public LivroDTO setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public LivroDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public String toString() {
        return "LivroDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
