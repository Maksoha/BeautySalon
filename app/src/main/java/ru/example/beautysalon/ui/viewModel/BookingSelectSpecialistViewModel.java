package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.SpecialistModel;
import ru.example.beautysalon.data.repositories.SpecialistRepository;

public class BookingSelectSpecialistViewModel extends AndroidViewModel {

    private SpecialistRepository specialistRepository;
    LiveData<List<SpecialistModel>> itemsSpecialistBrowsLashes,
            itemsSpecialistFacial, itemsSpecialistHaircut, itemsSpecialistMakeUp, itemsSpecialistManicure,
            itemsSpecialistWaxing;

    public BookingSelectSpecialistViewModel(Application application) {
        super(application);
        specialistRepository = new SpecialistRepository(application);
        itemsSpecialistBrowsLashes = specialistRepository.getDatabaseDataBrowsLashes();
        itemsSpecialistFacial = specialistRepository.getDatabaseDataFacial();
        itemsSpecialistHaircut = specialistRepository.getDatabaseDataHaircut();
        itemsSpecialistMakeUp = specialistRepository.getDatabaseDataMakeUp();
        itemsSpecialistManicure = specialistRepository.getDatabaseDataManicure();
        itemsSpecialistWaxing = specialistRepository.getDatabaseDataWaxing();
    }


    public LiveData<List<SpecialistModel>> getItemsSpecialistBrowsLashes() {
        return itemsSpecialistBrowsLashes;
    }

    public LiveData<List<SpecialistModel>> getItemsSpecialistFacial() {
        return itemsSpecialistFacial;
    }

    public LiveData<List<SpecialistModel>> getItemsSpecialistHaircut() {
        return itemsSpecialistHaircut;
    }

    public LiveData<List<SpecialistModel>> getItemsSpecialistMakeUp() {
        return itemsSpecialistMakeUp;
    }

    public LiveData<List<SpecialistModel>> getItemsSpecialistManicure() {
        return itemsSpecialistManicure;
    }

    public LiveData<List<SpecialistModel>> getItemsSpecialistWaxing() {
        return itemsSpecialistWaxing;
    }
}
