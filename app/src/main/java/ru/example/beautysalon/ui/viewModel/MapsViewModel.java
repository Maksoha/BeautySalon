package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MapsViewModel extends AndroidViewModel {

    private MutableLiveData<String> address = new MutableLiveData<>();

    public MapsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }
}
