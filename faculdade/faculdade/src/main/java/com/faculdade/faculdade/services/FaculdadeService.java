package com.faculdade.faculdade.services;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaculdadeService {
    @Autowired
    AlunoRepository alunoRepository;

    public Aluno findById(Integer ra) {
        Optional<Aluno> aluno = alunoRepository.findById(ra);
        return aluno.orElse(null);
    }

    public List<Aluno> listarTodosAbertos(){
        List<Aluno> alunos = alunoRepository.listarTodosAbertos();
        return alunos;
    }

    public List<Aluno> listarTodosFechados(){
        List<Aluno> alunos = alunoRepository.listarTodosFechados();
        return alunos;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public Aluno findByNome(String nome) {
        Optional<Aluno> alunos = alunoRepository.findByNome(nome);
        return alunos.orElse(null);
    }

    public Aluno findByCpf(String cpf) {
        Optional<Aluno> alunos = alunoRepository.findByCpf(cpf);
        return alunos.orElse(null);
    }

    public Aluno findByCurso(String curso) {
        Optional<Aluno> alunos = alunoRepository.findByCurso(curso);
        return alunos.orElse(null);
    }

    public Aluno gravarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Integer ra) {
        alunoRepository.deleteById(ra);
    }

    public Aluno updateAluno(Integer ra, Aluno aluno) {
        Aluno alterado = findById(ra);
        if (alterado != null) {
            alterado.setNome(aluno.getNome());
            alterado.setCpf(aluno.getCpf());
            alterado.setCurso(aluno.getCurso());
            alterado.setDataCadastro(aluno.getDataCadastro());
            alterado.setAtivo(aluno.isAtivo());

            return alunoRepository.save(alterado);
        }
        return null;
    }
}
