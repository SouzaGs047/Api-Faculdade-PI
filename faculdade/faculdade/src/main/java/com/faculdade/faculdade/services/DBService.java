package com.faculdade.faculdade.services;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Bean
    public void instanciarDB() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Aluno aluno1 = new Aluno("Gustavo Souza Santana","11122233344","ADS", LocalDate.parse("20/07/2004", formato), true);
        Aluno aluno2 = new Aluno("Jéssica Souza Santana","22233344455","Enfermagem", LocalDate.parse("08/09/2004", formato), true);
        Aluno aluno3 = new Aluno("Sofia Souza Santana","33344455566","Médica", LocalDate.parse("15/03/2035", formato), false);
        Aluno aluno4 = new Aluno("Bernado Souza Santana","44455566677","Urubu do Pix Master", LocalDate.parse("15/06/2036", formato), false);

        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
    }

}
