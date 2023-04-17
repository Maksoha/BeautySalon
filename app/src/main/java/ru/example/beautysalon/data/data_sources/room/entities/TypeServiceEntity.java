package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.TypeServiceModel;

@Entity
public class TypeServiceEntity {

    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo
    public String value;

    public TypeServiceEntity() {
    }

    public TypeServiceEntity(String value) {
        this.value = value;
    }

    public TypeServiceModel toDomainModel() {
        return new TypeServiceModel(value);
    }
}
