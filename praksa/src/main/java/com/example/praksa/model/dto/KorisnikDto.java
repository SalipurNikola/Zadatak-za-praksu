package com.example.praksa.model.dto;

import java.time.LocalDate;

public class KorisnikDto {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;

    public KorisnikDto() {
    }

    public KorisnikDto(Long id, String korisnickoIme, String lozinka, String ime, String prezime, LocalDate datumRodjenja) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public KorisnikDto(String korisnickoIme, String lozinka, String ime, String prezime, LocalDate datumRodjenja) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
