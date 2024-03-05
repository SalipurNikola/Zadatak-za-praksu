package com.example.praksa.service;

import com.example.praksa.model.Korisnik;
import com.example.praksa.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikLoginService {
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikLoginService (KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
}
