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
    private List<Aluno> alunos = new ArrayList<>();

    AlunoService alunoService = new AlunoService();


    @GetMapping
    public  List<Aluno> findByName(@RequestParam(required = false) String name, Integer id){
        if(name != null) {
            return alunoService.findByName(name);

        } else if(id != null) {
            return alunoService.findById(id);
        }
        return alunoService.listarAlunos();

    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno){
        alunoService.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED);
    }

    @PutMapping
    public void updateAlumn(@RequestBody final Aluno aluno){
        alunoService.updateAlumn(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        alunoService.delete(id);
    }


}
