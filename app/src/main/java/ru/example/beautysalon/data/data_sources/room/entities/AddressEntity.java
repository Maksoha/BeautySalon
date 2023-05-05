package ru.example.beautysalon.data.data_sources.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.AddressModel;

@Entity
public class AddressEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String address;

    public AddressEntity() {
    }

    public AddressEntity(String address) {
        this.address = address;
    }

    public AddressModel toDomainModel() {return new AddressModel(address);}
}
