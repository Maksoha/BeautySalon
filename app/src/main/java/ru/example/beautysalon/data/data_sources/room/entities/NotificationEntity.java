package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.NotificationModel;

@Entity
public class NotificationEntity {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo
    public String date, title, description;

    public NotificationEntity() {
    }

    public NotificationEntity(String date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public NotificationModel toDomainModel() {return new NotificationModel(date, title, description);}
}
