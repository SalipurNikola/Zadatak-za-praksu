package com.example.praksa.model.dto;

import com.example.praksa.model.Priority;
import jakarta.persistence.Column;

public class ToDoDto {
    private Long id;
    private  String naslov;
    private  String opis;
    private  Priority priority;
    private  Boolean completed;

    public ToDoDto() {
    }

    public ToDoDto(Long id, String naslov, String opis, Priority priority, Boolean completed) {
        this.id = id;
        this.naslov = naslov;
        this.opis = opis;
        this.priority = priority;
        this.completed = completed;
    }

    public ToDoDto(String naslov, String opis, Priority priority, Boolean completed) {
        this.naslov = naslov;
        this.opis = opis;
        this.priority = priority;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public static String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public static Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public static Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
