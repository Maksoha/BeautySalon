package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.AddressEntity;

@Dao
public interface AddressDao {

    @Insert
    void addNewItem(AddressEntity newItem);

    @Query("SELECT * FROM AddressEntity ORDER BY address ASC")
    LiveData<List<AddressEntity>> getAllItems();
}
