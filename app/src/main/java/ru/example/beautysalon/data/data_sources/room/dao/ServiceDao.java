package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.CardSpecialistEntity;
import ru.example.beautysalon.data.data_sources.room.entities.ServiceEntity;

public interface ServiceDao {

    @Query("SELECT * FROM ServiceEntity ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getAllItems();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Лашмейкер\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getBrowsLashes();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Косметолог\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getFacial();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Парикмахер\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getHairCut();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Визажист\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getMakeUp();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Мастер ногтевого сервиса\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getManicure();

    @Query("SELECT * FROM ServiceEntity WHERE name = \"Мастер депиляции\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getWaxing();

    @Insert
    void addNewItem(ServiceEntity serviceEntity);
}
