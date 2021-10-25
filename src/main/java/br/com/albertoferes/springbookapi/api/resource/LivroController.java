package br.com.albertoferes.springbookapi.api.resource;

import br.com.albertoferes.springbookapi.model.entity.Livro;
import br.com.albertoferes.springbookapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        List<Livro> livros = service.buscarTodos();

        if (Boolean.FALSE.equals(livros.isEmpty())) {
            return ResponseEntity.ok().body(livros);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro livroSalvo = service.salvar(livro);
        if (Objects.nonNull(livroSalvo.getId())) {
            return ResponseEntity.ok().body(livroSalvo);
        }
        return ResponseEntity.internalServerError().build();
    }
}
