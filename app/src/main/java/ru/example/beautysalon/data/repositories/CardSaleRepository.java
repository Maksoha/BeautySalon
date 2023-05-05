package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.room.entities.CardSaleEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.CardSaleModel;

public class CardSaleRepository {

    private AppDataBase appDataBase;

    public CardSaleRepository(Application application) {
        this.appDataBase = AppDataBase.getDataBase(application);
    }


    public LiveData<List<CardSaleModel>> getDatabaseData() {
        return Transformations.map(
                appDataBase.cardSaleDao().getAllItems(),
                values -> values.stream().map(CardSaleEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addNewItem(CardSaleModel newItem) {
        AppDataBase.databaseWriterExecutor.execute(() -> {
            appDataBase.cardSaleDao().addNewItem(new CardSaleEntity(newItem.getText()));
        });
    }
}
