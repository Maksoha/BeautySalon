package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ServiceViewModel extends AndroidViewModel {

    private MutableLiveData<String> typeService = new MutableLiveData<>();

    public ServiceViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService.setValue(typeService);
    }
}
