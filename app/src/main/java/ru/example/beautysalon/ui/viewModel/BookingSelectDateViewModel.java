package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.TimeModel;
import ru.example.beautysalon.data.repositories.TimeRepository;

public class BookingSelectDateViewModel extends AndroidViewModel {

    private TimeRepository repository;

    LiveData<List<TimeModel>> itemsTime;

    public BookingSelectDateViewModel(@NonNull Application application) {
        super(application);

        repository = new TimeRepository(application);
        itemsTime = repository.getDatabaseData();
    }

    public LiveData<List<TimeModel>> getItemsTime() {
        return itemsTime;
    }
}
