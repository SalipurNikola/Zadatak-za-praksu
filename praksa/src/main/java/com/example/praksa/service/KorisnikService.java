package com.example.praksa.service;

import com.example.praksa.model.Korisnik;
import com.example.praksa.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository; }

    public Korisnik create (Korisnik korisnik) throws Exception{
        if(korisnik.getId() != null){
            throw new Exception("Ovaj korisnik vec postoji");
        }
        Korisnik noviKorisnik = this.korisnikRepository.save(korisnik);
        return noviKorisnik;
    }

    public Korisnik findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka){
        return korisnikRepository.findAllByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
    }

}
