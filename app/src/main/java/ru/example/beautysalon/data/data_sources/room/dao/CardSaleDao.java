package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.CardSaleEntity;

@Dao
public interface CardSaleDao {

    @Query("SELECT * FROM CardSaleEntity")
    LiveData<List<CardSaleEntity>> getAllItems();

    @Insert
    void addNewItem(CardSaleEntity newItem);

}

