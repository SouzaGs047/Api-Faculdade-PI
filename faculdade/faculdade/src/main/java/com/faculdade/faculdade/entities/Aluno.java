package com.faculdade.faculdade.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Entity (name = "Alunos")
@Getter
@Setter
@ToString
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "RA")
    int RA;

    @Column (name = "Nome")
    String nome;

    @Column (name = "CPF")
    String cpf;

    @Column(name = "Curso")
    String curso;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column (name = "Data_Cadastro")
    LocalDate dataCadastro;

    @Column (name = "Ativo")
    private boolean ativo;

    public Aluno() {}

    public Aluno(String nome,String cpf, String curso, LocalDate dataCadastro, boolean ativo) {
        this.nome = nome;
        this.cpf = formatCpf(cpf);
        this.curso = curso;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    private String formatCpf(String cpf){
        return cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
    }
}
