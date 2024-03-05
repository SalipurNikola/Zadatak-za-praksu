package com.example.praksa.repository;

import com.example.praksa.model.Korisnik;
import com.example.praksa.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByKorisnik (Korisnik korisnik);
    ToDo findAllById (Long id);
}
