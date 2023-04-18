package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.TypeServiceEntity;

@Dao
public interface TypeServiceDao {

    @Query("SELECT * FROM TypeServiceEntity")
    LiveData<List<TypeServiceEntity>> getAllItems();

    @Query("SELECT * FROM TypeServiceEntity WHERE value <> \"Все\"")
    LiveData<List<TypeServiceEntity>> getAllItemsWithoutAll();
    @Insert
    void addNewItem(TypeServiceEntity typeServiceEntity);
}
