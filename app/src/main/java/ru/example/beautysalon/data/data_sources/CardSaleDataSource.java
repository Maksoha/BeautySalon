package ru.example.beautysalon.data.data_sources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ru.example.beautysalon.data.models.CardSaleModel;

public class CardSaleDataSource {
    public LiveData<List<CardSaleModel>> items() {
        MutableLiveData<List<CardSaleModel>> result = new MutableLiveData<>();
        new Thread(() -> {
            ArrayList<CardSaleModel> resultArr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                resultArr.add(new CardSaleModel("Акция"));
            }
            result.postValue(resultArr);
        }).start();
        return result;
    }
}
