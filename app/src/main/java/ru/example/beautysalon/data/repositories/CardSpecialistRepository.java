package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.CardSpecialistDataSource;
import ru.example.beautysalon.data.data_sources.room.entities.CardSpecialistEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.CardSpecialistModel;

public class CardSpecialistRepository {

    private CardSpecialistDataSource dataSource;
    private AppDataBase dataBase;

    public CardSpecialistRepository(Application application) {
        dataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseData() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getAllItems(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataBrowsLashes() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getBrowsLashes(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataFacial() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getFacial(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataHaircut() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getHairCut(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataMakeUp() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getMakeUp(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataManicure() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getManicure(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<CardSpecialistModel>> getDatabaseDataWaxing() {
        return Transformations.map(
                dataBase.cardSpecialistDao().getWaxing(),
                values -> values.stream().map(CardSpecialistEntity::toDomainModel).collect(Collectors.toList())
        );
    }
}
