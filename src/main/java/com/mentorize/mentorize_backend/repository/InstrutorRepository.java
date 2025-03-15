package com.mentorize.mentorize_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorize.mentorize_backend.model.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long>{
    Optional<Instrutor> findByEmail(String email);
}
