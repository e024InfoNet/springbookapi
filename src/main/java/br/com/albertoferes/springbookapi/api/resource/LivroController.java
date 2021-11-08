package br.com.albertoferes.springbookapi.api.resource;

import br.com.albertoferes.springbookapi.api.resource.dto.LivroDTO;
import br.com.albertoferes.springbookapi.model.entity.Livro;
import br.com.albertoferes.springbookapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAll() {
        List<LivroDTO> livros = service.buscarTodos()
                .stream()
                .map(LivroDTO::criar)
                .collect(Collectors.toList());

        if (Boolean.FALSE.equals(livros.isEmpty())) {
            return ResponseEntity.ok().body(livros);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@RequestBody Livro livro) {
        Livro livroSalvo = service.salvar(livro);
        if (Objects.nonNull(livroSalvo.getId())) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(livroSalvo.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
