package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.AddressEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.AddressModel;

public class AddressRepository {

    private AppDataBase appDataBase;

    public AddressRepository(Application application) {
        appDataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<AddressModel>> getDatabaseData() {
        return Transformations.map(
                appDataBase.addressDao().getAllItems(),
                values -> values.stream().map(AddressEntity::toDomainModel).collect(Collectors.toList())
        );
    }
}
