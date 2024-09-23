package com.faculdade.faculdade.resource;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.services.FaculdadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/faculdade")
public class FaculdadeResource {

    private final FaculdadeService faculdadeService;

    @GetMapping
    public List<Aluno> findAll(){
        List<Aluno> alunos = faculdadeService.findAll();
        return alunos;
    }

    public FaculdadeResource(FaculdadeService faculdadeService) {
        this.faculdadeService = faculdadeService;
    }

    @GetMapping(value = "/{ra}")
    public ResponseEntity<Aluno> findByRA(@PathVariable Integer ra){
        Aluno aluno = faculdadeService.findById(ra);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping(value ="/abertos")
    public ResponseEntity<List<Aluno>> listarAbertos(){
        List<Aluno> alunos = faculdadeService.listarTodosAbertos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping(value ="/fechados")
    public ResponseEntity<List<Aluno>> listarFechados(){
        List<Aluno> alunos = faculdadeService.listarTodosFechados();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Aluno> findByNome(@PathVariable String nome) {
        Aluno alunos = faculdadeService.findByNome(nome);
        return ResponseEntity.ok().body(alunos);
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Aluno> findByCpf(@PathVariable String cpf) {
        Aluno alunos = faculdadeService.findByCpf(cpf);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/curso/{curso}")
    public ResponseEntity<Aluno> findByCurso(@PathVariable String curso) {
        Aluno alunos = faculdadeService.findByCurso(curso);
        return ResponseEntity.ok().body(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> gravarAluno(@RequestBody Aluno aluno) {
        Aluno alunos = faculdadeService.gravarAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunos.getRA()).toUri();
        return ResponseEntity.created(uri).body(alunos);
    }

    @DeleteMapping(value = "/{ra}")
    public ResponseEntity<Void> delete(@PathVariable Integer ra){
        faculdadeService.deletarAluno(ra);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{ra}")
    public ResponseEntity<Aluno> update(@PathVariable Integer ra, @RequestBody Aluno aluno){
        aluno.setRA(ra);
        aluno = faculdadeService.updateAluno(ra, aluno);
        return ResponseEntity.ok().body(aluno);
    }

}
