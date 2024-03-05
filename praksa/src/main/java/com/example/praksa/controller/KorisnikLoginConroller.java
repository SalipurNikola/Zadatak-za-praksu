package com.example.praksa.controller;

import com.example.praksa.model.Korisnik;
import com.example.praksa.model.dto.KorisnikLoginDto;
import com.example.praksa.service.KorisnikLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class KorisnikLoginConroller {
    private final KorisnikLoginService korisnikLoginService;

    @Autowired
    public KorisnikLoginConroller(KorisnikLoginService korisnikLoginService){
        this.korisnikLoginService = korisnikLoginService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikLoginDto> login(@RequestBody KorisnikLoginDto korisnikLoginDto){
        KorisnikLoginDto korisnikLoginDto1 = new KorisnikLoginDto(korisnikLoginDto.getId(), korisnikLoginDto.getKorisnickoIme(), korisnikLoginDto.getLozinka());
        List<Korisnik> korisnici = korisnikLoginService.findAll();
        for(Korisnik korisnik : korisnici){
            if(korisnik.getKorisnickoIme().equals(korisnikLoginDto1.getKorisnickoIme())){
                if(korisnik.getLozinka().equals(korisnikLoginDto1.getLozinka())){
                    korisnikLoginDto1.setId(korisnik.getId());
                    return new ResponseEntity<>(korisnikLoginDto1, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(korisnikLoginDto1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(korisnikLoginDto1, HttpStatus.NOT_FOUND);
    }
}
