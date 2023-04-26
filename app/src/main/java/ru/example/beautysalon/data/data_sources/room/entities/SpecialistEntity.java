package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.SpecialistModel;

@Entity
public class SpecialistEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String name, speciality;

    public SpecialistEntity() {
    }

    public SpecialistEntity(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public SpecialistModel toDomainModel() {
        return new SpecialistModel(name, speciality);
    }
}
