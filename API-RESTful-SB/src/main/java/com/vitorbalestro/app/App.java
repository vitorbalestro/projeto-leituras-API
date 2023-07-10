package com.vitorbalestro.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vitorbalestro.model.Livro;
import com.vitorbalestro.model.Resenha;
import com.vitorbalestro.repository.LivroRepository;
import com.vitorbalestro.repository.ResenhaRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vitorbalestro"})
@EntityScan("com.vitorbalestro.model")
@EnableJpaRepositories("com.vitorbalestro.repository")
public class App implements CommandLineRunner {
	
	@Autowired 
	private LivroRepository livroRepository;
	
	@Autowired
	private ResenhaRepository resenhaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Livro livro1 = new Livro("O sol é para todos", "Harper Lee");
		livroRepository.save(livro1);
		
		Resenha resenha1 = new Resenha(livro1,"Livro bom!","@johndoe");
		resenhaRepository.save(resenha1);
		
		Resenha resenha2 = new Resenha(livro1,"Livro muito bom!", "@susandoe");
		resenhaRepository.save(resenha2);
		
		Livro livro2 = new Livro("Os miseráveis", "Victor Hugo");
		livroRepository.save(livro2);
		
		Livro livro3 = new Livro("Harry Potter", "J K Rowling");
		livroRepository.save(livro3);
		
		Livro livro4 = new Livro("Guerra e Paz", "Liev Tolstoi");
		livroRepository.save(livro4);
		
		Livro livro5 = new Livro("Crime e Castigo","Fiodor Dostoievski");
		livroRepository.save(livro5);
		
		Livro livro6 = new Livro("Memorias Postumas de Bras Cubas", "Machado de Assis");
		livroRepository.save(livro6);
		
	}
	
}
