package ru.example.beautysalon.ui.viewModel.viewPagerSpecialist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.CardSpecialistModel;
import ru.example.beautysalon.data.repositories.CardSpecialistRepository;

public class MakeUpViewModel extends AndroidViewModel {
    private CardSpecialistRepository specialistRepository;
    private LiveData<List<CardSpecialistModel>> itemsSpecialist;

    public MakeUpViewModel(@NonNull Application application) {
        super(application);
        specialistRepository = new CardSpecialistRepository(application);
        itemsSpecialist = specialistRepository.getDatabaseDataMakeUp();
    }

    public LiveData<List<CardSpecialistModel>> getItemsSpecialist() {
        return itemsSpecialist;
    }
}
