package br.com.albertoferes.springbookapi.service;

import br.com.albertoferes.springbookapi.model.entity.Livro;
import br.com.albertoferes.springbookapi.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService implements ILivroService {

    @Autowired
    private LivroRepository repository;

    @Override
    public List<Livro> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    @Override
    public Livro buscarPorIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }
}
