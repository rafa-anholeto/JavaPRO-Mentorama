package com.example.exspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final List<Aluno> alunos;


    public AlunoController() {
        this.alunos = new ArrayList<>();

    }

    @GetMapping
    public List<Aluno> findByName(@RequestParam(required = false) String name){
        if(name != null){
            return alunos.stream().filter(alum -> alum.getName().contains(name)).collect(Collectors.toList());
        }
        return alunos;
    }

    @GetMapping("/{id}")
    public List<Aluno> findById(@PathVariable("id") Integer id){
        if(id != null){
            return alunos.stream().filter(alum -> alum.getId().equals(id)).collect(Collectors.toList());
        }
        return alunos;
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size()+ 1);
        }
        alunos.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Aluno aluno){
        alunos.stream().filter(alum -> alum.getId().equals(aluno.getId())).forEach(alum -> alum.setName(aluno.getName()));
        alunos.stream().filter(alum -> alum.getAge().equals(aluno.getAge())).forEach(alum -> alum.setAge(aluno.getAge()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        alunos.removeIf(alum -> alum.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
