package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.TypeServiceModel;
import ru.example.beautysalon.data.repositories.TypeServiceRepository;

public class BookingViewModel extends AndroidViewModel {

    private TypeServiceRepository typeServiceRepository;

    private LiveData<List<TypeServiceModel>> itemsService;

    public BookingViewModel(@NonNull Application application) {
        super(application);

        typeServiceRepository = new TypeServiceRepository(application);

        itemsService = typeServiceRepository.getDatabaseData();
    }

    public LiveData<List<TypeServiceModel>> getItemsService() {return  itemsService;}
}
