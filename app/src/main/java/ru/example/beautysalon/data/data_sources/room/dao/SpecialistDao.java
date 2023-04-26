package ru.example.beautysalon.data.data_sources.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.example.beautysalon.data.data_sources.room.entities.SpecialistEntity;

@Dao
public interface SpecialistDao {

    @Insert
    void addNewItem(SpecialistEntity specialistEntity);

    @Query("SELECT * FROM SpecialistEntity ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getAllItems();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Лашмейкер\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getBrowsLashes();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Косметолог\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getFacial();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Парикмахер\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getHairCut();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Визажист\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getMakeUp();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Мастер ногтевого сервиса\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getManicure();

    @Query("SELECT * FROM SpecialistEntity WHERE speciality = \"Мастер депиляции\" ORDER BY name ASC")
    LiveData<List<SpecialistEntity>> getWaxing();

}
