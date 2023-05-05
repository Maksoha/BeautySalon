package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.SpecialistEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.SpecialistModel;

public class SpecialistRepository {

    private AppDataBase appDataBase;

    public SpecialistRepository(Application application) {
        appDataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<SpecialistModel>> getDatabaseData() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getAllItems(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataBrowsLashes() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getBrowsLashes(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataFacial() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getFacial(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataHaircut() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getHairCut(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataMakeUp() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getMakeUp(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataManicure() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getManicure(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<SpecialistModel>> getDatabaseDataWaxing() {
        return Transformations.map(
                appDataBase.cardSpecialistDao().getWaxing(),
                values -> values.stream().map(SpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }
}
