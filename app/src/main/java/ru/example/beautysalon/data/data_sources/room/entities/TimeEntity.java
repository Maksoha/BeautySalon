package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import ru.example.beautysalon.data.models.TimeModel;

@Entity
public class TimeEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String value;

    public TimeEntity() {

    }
    public TimeEntity(String value) {
        this.value = value;
    }

    public TimeModel toDomainModel() {
        return new TimeModel(value);
    }
}
