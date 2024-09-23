package com.faculdade.faculdade;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FaculdadeApplication /*implements CommandLineRunner*/ {
	@Autowired
	private AlunoRepository alunoRepository;
	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
	}


}
