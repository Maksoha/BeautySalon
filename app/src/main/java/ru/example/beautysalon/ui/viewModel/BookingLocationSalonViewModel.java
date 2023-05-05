package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.AddressModel;
import ru.example.beautysalon.data.repositories.AddressRepository;

public class BookingLocationSalonViewModel extends AndroidViewModel {

    private AddressRepository addressRepository;

    LiveData<List<AddressModel>> itemsAddress;
    public BookingLocationSalonViewModel(@NonNull Application application) {
        super(application);

        addressRepository = new AddressRepository(application);
        itemsAddress = addressRepository.getDatabaseData();
    }

    public LiveData<List<AddressModel>> getItemsAddress() {
        return itemsAddress;
    }
}
