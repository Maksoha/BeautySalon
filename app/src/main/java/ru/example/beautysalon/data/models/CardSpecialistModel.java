package ru.example.beautysalon.data.models;

public class CardSpecialistModel {
    private String name;
    private String speciality;

    public CardSpecialistModel(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

}
