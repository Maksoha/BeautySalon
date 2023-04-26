package ru.example.beautysalon.ui.viewModel;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> typeService = new MutableLiveData<>();

    public LiveData<String> getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService.setValue(typeService);
    }
}
