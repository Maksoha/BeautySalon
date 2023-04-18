package ru.example.beautysalon.ui.viewModel.viewPagerService;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.data.repositories.ServicesRepository;

public class HaircutServiceViewModel extends AndroidViewModel {
    private ServicesRepository servicesRepository;
    private LiveData<List<ServiceModel>> itemsService;

    public HaircutServiceViewModel(@NonNull Application application) {
        super(application);
        servicesRepository = new ServicesRepository(application);
        itemsService = servicesRepository.getDatabaseDataHaircut();
    }

    public LiveData<List<ServiceModel>> getItemsSpecialist() {
        return itemsService;
    }
}
