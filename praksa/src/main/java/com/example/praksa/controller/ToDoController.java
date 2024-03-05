package com.example.praksa.controller;

import com.example.praksa.model.Korisnik;
import com.example.praksa.model.ToDo;
import com.example.praksa.model.dto.ToDoDto;
import com.example.praksa.service.KorisnikService;
import com.example.praksa.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    private final ToDoService toDoService;
    private final KorisnikService korisnikService;


    @Autowired
    public ToDoController(ToDoService toDoService, KorisnikService korisnikService){
        this.toDoService = toDoService;
        this.korisnikService = korisnikService;
    }

    @PostMapping(value = "/{korisnikid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoDto> create(@PathVariable Long korisnikid, @RequestBody ToDoDto toDoDto)throws Exception{
        Korisnik korisnik = korisnikService.findOne(korisnikid);
        ToDo toDo = new ToDo(ToDoDto.getNaslov(),ToDoDto.getOpis(),ToDoDto.getPriority(),ToDoDto.getCompleted() ,korisnik);
        ToDo noviToDo = ToDoService.create(toDo);
        ToDoDto toDoDto1 = new ToDoDto(noviToDo.getId(), noviToDo.getNaslov(), noviToDo.getOpis(), noviToDo.getPriority(), noviToDo.getCompleted());
        return new ResponseEntity<>(toDoDto1, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToDoDto>> findAll(){
        List<ToDo> toDoList = ToDoService.findAll();
        List<ToDoDto> toDoDtos = new ArrayList<>();
        for(ToDo toDo:toDoList){
            ToDoDto toDoDto = new ToDoDto(toDo.getId(), toDo.getNaslov(), toDo.getOpis(), toDo.getPriority(), toDo.getCompleted());
            toDoDtos.add(toDoDto);
        }
        return new ResponseEntity<>(toDoDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/findkorisnik/{korisnikid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ToDoDto>> findByKorisnik(@PathVariable Long korisnikid){
        Korisnik korisnik = korisnikService.findOne(korisnikid);
        List<ToDo> toDoList = ToDoService.findAllByKorisnik(korisnik);
        List<ToDoDto> toDoDtos = new ArrayList<>();
        for(ToDo toDo:toDoList){
            ToDoDto toDoDto = new ToDoDto(toDo.getId(), toDo.getNaslov(), toDo.getOpis(), toDo.getPriority(), toDo.getCompleted());
            toDoDtos.add(toDoDto);
        }
        return new ResponseEntity<>(toDoDtos, HttpStatus.OK);
    }



    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoDto> update(@PathVariable Long id, @RequestBody ToDoDto toDoDto) throws Exception{
        ToDo toDo = new ToDo(toDoDto.getNaslov(), toDoDto.getOpis(), toDoDto.getPriority(), toDoDto.getCompleted());
        toDo.setId(id);
        ToDo updateToDo = toDoService.update(toDo);
        ToDoDto toDoDto1 = new ToDoDto(updateToDo.getId(), updateToDo.getNaslov(), updateToDo.getOpis(), updateToDo.getPriority(), updateToDo.getCompleted());
        return new ResponseEntity<>(toDoDto1, HttpStatus.OK);
    }
}
