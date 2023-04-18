package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.ServiceModel;

@Entity
public class ServiceEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String type, name;

    @ColumnInfo
    public int price;

    public ServiceEntity() {
    }

    public ServiceEntity(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public ServiceModel toDomainMode() {return new ServiceModel(type, name, price);}
}
