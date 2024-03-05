package com.example.praksa.controller;

import com.example.praksa.model.Korisnik;
import com.example.praksa.model.dto.KorisnikDto;
import com.example.praksa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/korisnik")
public class KorisnikController {
    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> createKorisnik(@RequestBody KorisnikDto korisnikDto) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDto.getKorisnickoIme(), korisnikDto.getLozinka(), korisnikDto.getIme(), korisnikDto.getPrezime(),
                korisnikDto.getDatumRodjenja());

        Korisnik newKorisnik = korisnikService.create(korisnik);

        KorisnikDto newKorisnikDto = new KorisnikDto(newKorisnik.getId(), newKorisnik.getKorisnickoIme(), newKorisnik.getLozinka(), newKorisnik.getIme(),
                newKorisnik.getPrezime(),newKorisnik.getDatumRodjenja());

        return new ResponseEntity<>(newKorisnikDto, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDto>> findAll(){
        List<Korisnik> korisnici = korisnikService.findAll();

        List<KorisnikDto> korisnikDtos = new ArrayList<>();

        for(Korisnik korisnik : korisnici){
            KorisnikDto korisnikDto = new KorisnikDto(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getIme(),
                    korisnik.getPrezime(), korisnik.getDatumRodjenja());
            korisnikDtos.add(korisnikDto);
        }

        return new ResponseEntity<>(korisnikDtos, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> findOne(@PathVariable Long id){
        Korisnik korisnik = korisnikService.findOne(id);
        KorisnikDto korisnikDto = new KorisnikDto(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getIme(), korisnik.getPrezime(),
                korisnik.getDatumRodjenja());
        return new ResponseEntity<>(korisnikDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{korisnickoime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDto> findByKorImeAndLozinka(@PathVariable String korisnickoIme, @PathVariable String lozinka){
        Korisnik korisnik = korisnikService.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
        KorisnikDto korisnikDto = new KorisnikDto(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getDatumRodjenja());
        return new ResponseEntity<>(korisnikDto, HttpStatus.OK);
    }


}
