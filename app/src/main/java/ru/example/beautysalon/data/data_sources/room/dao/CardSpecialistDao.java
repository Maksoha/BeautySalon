package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.CardSpecialistEntity;

@Dao
public interface CardSpecialistDao {

    @Insert
    void addNewItem(CardSpecialistEntity cardSpecialistEntity);

    @Query("SELECT * FROM CardSpecialistEntity ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getAllItems();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Лашмейкер\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getBrowsLashes();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Косметолог\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getFacial();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Парикмахер\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getHairCut();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Визажист\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getMakeUp();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Мастер ногтевого сервиса\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getManicure();

    @Query("SELECT * FROM CardSpecialistEntity WHERE speciality = \"Мастер депиляции\" ORDER BY name ASC")
    LiveData<List<CardSpecialistEntity>> getWaxing();

}
