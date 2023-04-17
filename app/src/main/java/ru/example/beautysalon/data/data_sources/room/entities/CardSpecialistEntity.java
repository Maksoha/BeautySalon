package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.CardSpecialistModel;

@Entity
public class CardSpecialistEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String name, speciality;

    public CardSpecialistEntity() {
    }

    public CardSpecialistEntity(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public CardSpecialistModel toDomainModel() {
        return new CardSpecialistModel(name, speciality);
    }
}
