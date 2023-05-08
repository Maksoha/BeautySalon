package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.PhotoModel;
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.data.models.SpecialistModel;
import ru.example.beautysalon.data.repositories.ServicesRepository;

public class SpecialistViewModel extends AndroidViewModel {

    private ServicesRepository servicesRepository;
    private MutableLiveData<SpecialistModel> specialist = new MutableLiveData<>();
    private LiveData<List<ServiceModel>> browsLashesItems;
    private LiveData<List<ServiceModel>> facialItems;
    private LiveData<List<ServiceModel>> haircutItems;
    private LiveData<List<ServiceModel>> makeUpItems;
    private LiveData<List<ServiceModel>> manicureItems;
    private LiveData<List<ServiceModel>> waxingItems;
    private LiveData<List<PhotoModel>> browsLashesImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.brows_lashes1), new PhotoModel(R.drawable.brows_lashes2), new PhotoModel(R.drawable.brows_lashes3), new PhotoModel(R.drawable.brows_lashes4), new PhotoModel(R.drawable.brows_lashes5)));
    private LiveData<List<PhotoModel>> facialImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.facial1), new PhotoModel(R.drawable.facial2), new PhotoModel(R.drawable.facial3), new PhotoModel(R.drawable.facial4), new PhotoModel(R.drawable.facial5)));
    private LiveData<List<PhotoModel>> haircutImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.haircut1), new PhotoModel(R.drawable.haircut2), new PhotoModel(R.drawable.haircut3), new PhotoModel(R.drawable.haircut4), new PhotoModel(R.drawable.haircut5)));
    private LiveData<List<PhotoModel>> makeUpImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.makeup1), new PhotoModel(R.drawable.makeup2), new PhotoModel(R.drawable.makeup3), new PhotoModel(R.drawable.makeup4), new PhotoModel(R.drawable.makeup5)));
    private LiveData<List<PhotoModel>> manicureImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.manicure1), new PhotoModel(R.drawable.manicure2), new PhotoModel(R.drawable.manicure3), new PhotoModel(R.drawable.manicure4), new PhotoModel(R.drawable.manicure5)));
    private LiveData<List<PhotoModel>> waxingImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.waxing1), new PhotoModel(R.drawable.waxing2), new PhotoModel(R.drawable.waxing3), new PhotoModel(R.drawable.waxing4), new PhotoModel(R.drawable.waxing5)));


    public SpecialistViewModel(@NonNull Application application) {
        super(application);

        servicesRepository = new ServicesRepository(application);

        browsLashesItems = servicesRepository.getDatabaseDataBrowsLashes();
        facialItems = servicesRepository.getDatabaseDataFacial();
        haircutItems = servicesRepository.getDatabaseDataHaircut();
        makeUpItems = servicesRepository.getDatabaseDataMakeUp();
        manicureItems = servicesRepository.getDatabaseDataManicure();
        waxingItems = servicesRepository.getDatabaseDataWaxing();
    }

    public LiveData<SpecialistModel> getSpecialist() {
        return specialist;
    }

    public void setSpecialist(SpecialistModel specialist) {
        this.specialist.setValue(specialist);
    }

    public LiveData<List<ServiceModel>> getBrowsLashesItems() {
        return browsLashesItems;
    }

    public LiveData<List<ServiceModel>> getFacialItems() {
        return facialItems;
    }

    public LiveData<List<ServiceModel>> getHaircutItems() {
        return haircutItems;
    }

    public LiveData<List<ServiceModel>> getMakeUpItems() {
        return makeUpItems;
    }

    public LiveData<List<ServiceModel>> getManicureItems() {
        return manicureItems;
    }

    public LiveData<List<ServiceModel>> getWaxingItems() {
        return waxingItems;
    }

    public LiveData<List<PhotoModel>> getBrowsLashesImageResources() {
        return browsLashesImageResources;
    }

    public LiveData<List<PhotoModel>> getFacialImageResources() {
        return facialImageResources;
    }

    public LiveData<List<PhotoModel>> getHaircutImageResources() {
        return haircutImageResources;
    }

    public LiveData<List<PhotoModel>> getMakeUpImageResources() {
        return makeUpImageResources;
    }

    public LiveData<List<PhotoModel>> getManicureImageResources() {
        return manicureImageResources;
    }

    public LiveData<List<PhotoModel>> getWaxingImageResources() {
        return waxingImageResources;
    }
}
