package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.TimeEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.TimeModel;

public class TimeRepository {

    private AppDataBase dataBase;

    public TimeRepository(Application application) {
        dataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<TimeModel>> getDatabaseData() {
        return Transformations.map(
                dataBase.timeDao().getAllItems(),
                values -> values.stream().map(TimeEntity::toDomainModel).collect(Collectors.toList())
        );
    }
}
