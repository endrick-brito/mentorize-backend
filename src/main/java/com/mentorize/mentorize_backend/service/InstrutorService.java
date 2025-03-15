package com.mentorize.mentorize_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorize.mentorize_backend.model.Instrutor;
import com.mentorize.mentorize_backend.repository.InstrutorRepository;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;


    /* findAll */
    public List<Instrutor> findAll(){
        return instrutorRepository.findAll();
    }

    /* findById */
    public Instrutor findById(Long id){
        return instrutorRepository.findById(id).orElse(null);
    }

    /* findByEmail */
    public Instrutor findByEmail(String email){
        return instrutorRepository.findByEmail(email).orElse(null);
    }

    /* insertNew */
    public Instrutor insertNew(Instrutor instrutorInserido){
        return instrutorRepository.save(instrutorInserido);
    }

    /* update */
    public Instrutor update(Long id, Instrutor instrutorInserido){
        Instrutor instrutorAlterado = findById(id);

        instrutorAlterado.setDataCadastro(instrutorInserido.getDataCadastro());
        instrutorAlterado.setEmail(instrutorInserido.getEmail());
        instrutorAlterado.setNome(instrutorInserido.getNome());
        instrutorAlterado.setSenha(instrutorInserido.getSenha());
        instrutorAlterado.setSobrenome(instrutorInserido.getSobrenome());
        
        return instrutorRepository.save(instrutorAlterado);
    }

    /* deleteByID */
    public Boolean deleteById(Long id){
        Instrutor instrutor = findById(id);
        if (instrutor == null){
            return false;
        }else{
            instrutorRepository.deleteById(id);
            return true;
        }
    }
}
