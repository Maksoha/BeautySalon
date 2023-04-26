package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.TimeEntity;

@Dao
public interface TimeDao {

    @Query("SELECT * FROM TimeEntity ORDER BY value ASC")
    LiveData<List<TimeEntity>> getAllItems();

    @Insert
    void addNewItem(TimeEntity newItem);



}
