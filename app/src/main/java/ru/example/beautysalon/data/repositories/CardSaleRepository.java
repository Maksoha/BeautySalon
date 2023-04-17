package ru.example.beautysalon.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.List;
import java.util.stream.Collectors;

import ru.example.beautysalon.data.data_sources.CardSaleDataSource;
import ru.example.beautysalon.data.data_sources.room.entities.CardSaleEntity;
import ru.example.beautysalon.data.data_sources.room.root.AppDataBase;
import ru.example.beautysalon.data.models.CardSaleModel;

public class CardSaleRepository {

    private CardSaleDataSource dataSource;
    private AppDataBase dataBase;

    public CardSaleRepository(Application application) {
        this.dataSource = new CardSaleDataSource();
        this.dataBase = AppDataBase.getDataBase(application);


    }

    public LiveData<List<CardSaleModel>> getData() {
        return dataSource.items();
    }


    public LiveData<List<CardSaleModel>> getDatabaseData() {
        return Transformations.map(
                dataBase.cardSaleDao().getAllItems(),
                values -> values.stream().map(CardSaleEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addNewItem(CardSaleModel newItem) {
        AppDataBase.databaseWriterExecutor.execute(() -> {
            dataBase.cardSaleDao().addNewItem(new CardSaleEntity(newItem.getText()));
        });
    }
}
