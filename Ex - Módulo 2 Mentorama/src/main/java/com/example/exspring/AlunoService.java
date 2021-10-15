package com.example.exspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoService {

    private final List<Aluno> alunos;


    public AlunoService() {
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> findByName(String name){
        List<Aluno> findedAlumnsByName = new ArrayList<>();
        findedAlumnsByName = alunos.stream().filter(alum -> alum.getName().contains(name)).collect(Collectors.toList());

        if(findedAlumnsByName.isEmpty()){
            throw new AlunoNaoEncontradoException();
        }
        return findedAlumnsByName;
    }

    public List<Aluno> findById(Integer id){
        List<Aluno> findedAlumnsById = new ArrayList<>();
        findedAlumnsById = alunos.stream().filter(alum -> alum.getId().equals(id)).collect(Collectors.toList());

        if (findedAlumnsById.isEmpty()){
            throw new AlunoNaoEncontradoException();
        }
        return findedAlumnsById;
    }

    public List<Aluno> listarAlunos() {

        if(alunos.isEmpty()) {
            throw new AlunoNaoEncontradoException();
        }
        return alunos;
    }


    public ResponseEntity<Integer> add(Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size()+ 1);
        }
        alunos.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }


    public ResponseEntity updateAlumn(@RequestBody final Aluno aluno){

        alunos.stream().filter(alum -> alum.getId().equals(aluno.getId())).forEach(alum -> alum.setName(aluno.getName()));
        alunos.stream().filter(alum -> alum.getAge().equals(aluno.getAge())).forEach(alum -> alum.setAge(aluno.getAge()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    public ResponseEntity delete(Integer id){
        alunos.removeIf(alum -> alum.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
