package com.example.praksa.service;

import com.example.praksa.model.Korisnik;
import com.example.praksa.model.ToDo;
import com.example.praksa.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private static ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }
    public static ToDo create(ToDo toDo) throws Exception{
        if(toDo.getId() != null){
            throw new Exception("Ovaj zadatak vec postoji");
        }
        return toDoRepository.save(toDo);
    }
    public static List<ToDo> findAll(){
        return toDoRepository.findAll();
    }

    public static List<ToDo> findAllByKorisnik(Korisnik korisnik){
        return toDoRepository.findAllByKorisnik(korisnik);
    }

    public ToDo update (ToDo toDo) throws Exception{
        ToDo updateToDo = toDoRepository.findAllById(toDo.getId());
        if (updateToDo.getId() == null){
            throw new Exception("Ovaj zadatak ne postoji");
        }
        updateToDo.setNaslov(toDo.getNaslov());
        updateToDo.setOpis(toDo.getOpis());
        updateToDo.setPriority(toDo.getPriority());
        updateToDo.setCompleted(toDo.getCompleted());
        return toDoRepository.save(updateToDo);
    }
}
