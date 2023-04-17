package ru.example.beautysalon.data.data_sources.room.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.example.beautysalon.data.models.CardSaleModel;

@Entity
public class CardSaleEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String value;

    public CardSaleEntity() {}

    public CardSaleEntity(String value) {
        this.value = value;
    }

    public CardSaleModel toDomainModel() {
        return new CardSaleModel(value);
    }
}
