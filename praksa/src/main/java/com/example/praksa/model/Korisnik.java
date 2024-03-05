package com.example.praksa.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
public class Korisnik implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String korisnickoime;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private LocalDate datumrodjenja;

    @OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ToDo>toDoSet = new HashSet<>();

    public Korisnik() {
    }

    public Korisnik(String korisnickoime, String lozinka, String ime, String prezime, LocalDate datumrodjenja) {
        this.korisnickoime = korisnickoime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumrodjenja = datumrodjenja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoime;
    }

    public void setKorisnickoIme(String korisnickoime) {
        this.korisnickoime = korisnickoime;
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
        return datumrodjenja;
    }

    public void setDatumRodjenja(LocalDate datumrodjenja) {
        this.datumrodjenja = datumrodjenja;
    }

    public Set<ToDo> getToDoSet() {
        return toDoSet;
    }

    public void setToDoSet(Set<ToDo> toDoSet) {
        this.toDoSet = toDoSet;
    }
}
