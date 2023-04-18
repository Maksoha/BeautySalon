package ru.example.beautysalon.ui.viewModel.viewPagerSpecialist;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.CardSpecialistModel;
import ru.example.beautysalon.data.repositories.CardSpecialistRepository;

public class BrowsLashesViewModel extends AndroidViewModel {

    private CardSpecialistRepository specialistRepository;
    private LiveData<List<CardSpecialistModel>> itemsSpecialist;

    public BrowsLashesViewModel(@NonNull Application application) {
        super(application);
        specialistRepository = new CardSpecialistRepository(application);
        itemsSpecialist = specialistRepository.getDatabaseDataBrowsLashes();
    }

    public LiveData<List<CardSpecialistModel>> getItemsSpecialist() {
        return itemsSpecialist;
    }
}
