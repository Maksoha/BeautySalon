package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.NotificationEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.NotificationModel;

public class NotificationRepository {

    private AppDataBase appDataBase;

    public NotificationRepository(Application application) {
        appDataBase = AppDataBase.getDataBase(application);
    }

    public LiveData<List<NotificationModel>> getDatabaseData() {
        return Transformations.map(
                appDataBase.notificationDao().getAllItems(),
                values -> values.stream().map(NotificationEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addNewItems(NotificationModel newItem) {
        AppDataBase.databaseWriterExecutor.execute(() -> {
            appDataBase.notificationDao().addNewItem(new NotificationEntity(newItem.getDate(), newItem.getTitle(), newItem.getDescription()));
        });
    }
}
