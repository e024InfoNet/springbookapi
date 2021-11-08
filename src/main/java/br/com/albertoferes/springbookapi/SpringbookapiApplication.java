package br.com.albertoferes.springbookapi;

import br.com.albertoferes.springbookapi.api.resource.dto.LivroDTO;
import br.com.albertoferes.springbookapi.model.entity.Livro;
import br.com.albertoferes.springbookapi.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbookapiApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbookapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Livro livro1 = new Livro("Matrix","Waschowski Brothers","123456789");
		Livro livro2 = new Livro("Matrix Reloaded","Waschowski Brothers","987654321");
		Livro livro3 = new Livro("Matrix Revolutions","Waschowski Brothers","123456987");
		Livro livro4 = new Livro("Matrix Ressurections","Waschowski Brothers","897123654");


		LivroDTO livroDTO = LivroDTO.criar(livro1);

		System.out.println(livroDTO);

		repository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4));

		repository.findAll().forEach(System.out::println);
	}
}
