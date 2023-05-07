package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.NotificationEntity;

@Dao
public interface NotificationDao {

    @Insert
    void addNewItem(NotificationEntity newItem);

    @Query("SELECT * FROM NotificationEntity")
    LiveData<List<NotificationEntity>> getAllItems();
}
