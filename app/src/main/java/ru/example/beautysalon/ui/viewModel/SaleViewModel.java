package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.example.beautysalon.data.models.CardSaleModel;
import ru.example.beautysalon.data.repositories.CardSaleRepository;

public class SaleViewModel extends AndroidViewModel {

    private CardSaleRepository saleRepository;

    private LiveData<List<CardSaleModel>> itemsSale;


    public SaleViewModel(@NonNull Application application) {
        super(application);

        saleRepository = new CardSaleRepository(application);
        itemsSale = saleRepository.getDatabaseData();
    }

    public LiveData<List<CardSaleModel>> getItemsSale() {return itemsSale;}
}