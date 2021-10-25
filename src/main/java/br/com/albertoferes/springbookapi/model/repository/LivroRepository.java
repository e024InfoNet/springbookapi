package br.com.albertoferes.springbookapi.model.repository;

import br.com.albertoferes.springbookapi.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Livro findByIsbn(String isbn);
}
