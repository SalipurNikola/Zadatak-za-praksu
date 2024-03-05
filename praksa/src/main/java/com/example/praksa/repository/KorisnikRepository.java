package com.example.praksa.repository;

import com.example.praksa.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findAllByKorisnickoimeAndLozinka (String korisnickoIme, String lozinka);

    Korisnik findAllByKorisnickoime (String korisnickoIme);

    Korisnik findAllById (Long id);
}
