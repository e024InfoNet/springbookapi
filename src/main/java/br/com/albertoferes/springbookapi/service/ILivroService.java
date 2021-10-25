package br.com.albertoferes.springbookapi.service;

import br.com.albertoferes.springbookapi.model.entity.Livro;


import java.util.List;

public interface ILivroService {
    List<Livro> buscarTodos();
    Livro salvar(Livro livro);
    Livro buscarPorIsbn(String isbn);
}
