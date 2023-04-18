package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.ServiceEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.ServiceModel;

public class ServicesRepository {
    private AppDataBase dataBase;

    public ServicesRepository(Application application) {
        dataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<ServiceModel>> getDatabaseData() {
        return Transformations.map(
                dataBase.serviceDao().getAllItems(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataBrowsLashes() {
        return Transformations.map(
                dataBase.serviceDao().getBrowsLashes(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataFacial() {
        return Transformations.map(
                dataBase.serviceDao().getFacial(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataHaircut() {
        return Transformations.map(
                dataBase.serviceDao().getHairCut(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataMakeUp() {
        return Transformations.map(
                dataBase.serviceDao().getMakeUp(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataManicure() {
        return Transformations.map(
                dataBase.serviceDao().getManicure(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

    public LiveData<List<ServiceModel>> getDatabaseDataWaxing() {
        return Transformations.map(
                dataBase.serviceDao().getWaxing(),
                values -> values.stream().map(ServiceEntity::toDomainMode).collect(Collectors.toList())
        );
    }

}
