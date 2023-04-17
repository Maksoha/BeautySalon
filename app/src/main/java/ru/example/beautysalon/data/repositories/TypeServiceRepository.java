package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.TypeServiceEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.TypeServiceModel;

public class TypeServiceRepository {
    private AppDataBase dataBase;
    public TypeServiceRepository(Application application) {
        dataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<TypeServiceModel>> getDatabaseData() {
        return Transformations.map(
                dataBase.serviceDao().getAllItems(),
                values -> values.stream().map(TypeServiceEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addItem(TypeServiceModel newItem) {
        AppDataBase.databaseWriterExecutor.execute(() ->{
            dataBase.serviceDao().addNewItem(new TypeServiceEntity(newItem.getText()));
        });
    }
}
