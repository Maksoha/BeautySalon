package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.ServiceEntity;

@Dao
public interface ServiceDao {

    @Query("SELECT * FROM ServiceEntity ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getAllItems();


    @Query("SELECT * FROM ServiceEntity WHERE type = \"Брови/Ресницы\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getBrowsLashes();

    @Query("SELECT * FROM ServiceEntity WHERE type = \"Косметология\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getFacial();

    @Query("SELECT * FROM ServiceEntity WHERE type = \"Парикмахер\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getHairCut();

    @Query("SELECT * FROM ServiceEntity WHERE type = \"Визаж\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getMakeUp();

    @Query("SELECT * FROM ServiceEntity WHERE type = \"Маникюр/Педикюр\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getManicure();

    @Query("SELECT * FROM ServiceEntity WHERE type = \"Депиляция\" ORDER BY name ASC")
    LiveData<List<ServiceEntity>> getWaxing();

    @Insert
    void addNewItem(ServiceEntity serviceEntity);
}
