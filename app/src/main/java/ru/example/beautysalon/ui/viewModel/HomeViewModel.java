package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.CardSaleModel;
import ru.example.beautysalon.data.models.TypeServiceModel;
import ru.example.beautysalon.data.repositories.CardSaleRepository;
import ru.example.beautysalon.data.repositories.TypeServiceRepository;

public class HomeViewModel extends AndroidViewModel {

    private CardSaleRepository cardSaleRepository;
    private TypeServiceRepository typeServiceRepository;

    private LiveData<List<CardSaleModel>> cardItemsSale;

    private LiveData<List<TypeServiceModel>> typeItemsServiceWithoutAll;
    private LiveData<List<TypeServiceModel>> typeItemsService;


    public HomeViewModel(@NonNull Application application) {
        super(application);

        cardSaleRepository = new CardSaleRepository(application);
        cardItemsSale = cardSaleRepository.getDatabaseData();

        typeServiceRepository = new TypeServiceRepository(application);
        typeItemsServiceWithoutAll = typeServiceRepository.getDatabaseDataWithoutAll();
        typeItemsService = typeServiceRepository.getDatabaseData();

    }

    public LiveData<List<CardSaleModel>> getItemsSale() {
        return cardItemsSale;
    }

    public LiveData<List<TypeServiceModel>> getTypeItemsServiceWithoutAll() {return typeItemsServiceWithoutAll;}
    public LiveData<List<TypeServiceModel>> getTypeItemsService() {return typeItemsService;}



}