package ru.example.beautysalon.ui.viewModel.viewPagerSpecialist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.SpecialistModel;
import ru.example.beautysalon.data.repositories.SpecialistRepository;

public class AllViewModel extends AndroidViewModel {

    private SpecialistRepository specialistRepository;
    private LiveData<List<SpecialistModel>> itemsSpecialist;

    public AllViewModel(@NonNull Application application) {
        super(application);

        specialistRepository = new SpecialistRepository(application);
        itemsSpecialist = specialistRepository.getDatabaseData();

    }

    public LiveData<List<SpecialistModel>> getItemsSpecialist() {
        return itemsSpecialist;
    }
}
