package com.mentorize.mentorize_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorize.mentorize_backend.model.Instrutor;
import com.mentorize.mentorize_backend.service.InstrutorService;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    
    @Autowired
    private InstrutorService instrutorService;

    /* findAll */
    @GetMapping
    public ResponseEntity<List<Instrutor>> findAll(){
        List<Instrutor> instrutores = instrutorService.findAll();
        return ResponseEntity.ok().body(instrutores);
    }

    /* findById */
    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable Long id){
        Instrutor instrutor = instrutorService.findById(id);
        return ResponseEntity.ok().body(instrutor);
    }

    /* findByEmail */
    @GetMapping("/{email}")
    public ResponseEntity<Instrutor> findByEmail(@PathVariable String email){
        Instrutor instrutor = instrutorService.findByEmail(email);
        return ResponseEntity.ok().body(instrutor);
    }

    /* insertNew */
    @PostMapping
    public ResponseEntity<?> insertNew(@RequestBody Instrutor instrutorInserido){
        Instrutor verificarInstrutorExistente = instrutorService.findByEmail(instrutorInserido.getEmail());
        
        if (verificarInstrutorExistente == null){
            Instrutor instrutor = instrutorService.insertNew(instrutorInserido);
            return ResponseEntity.status(HttpStatus.CREATED).body(instrutor);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado!");
        }

    }

    /* update */
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> update(@PathVariable Long id, @RequestBody Instrutor instrutorInserido){
        Instrutor instrutorAtual = instrutorService.update(id, instrutorInserido);
        return ResponseEntity.ok().body(instrutorAtual);
    }

    /* deleteById */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = instrutorService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
