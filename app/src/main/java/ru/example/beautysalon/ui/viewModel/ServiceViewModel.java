package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.PhotoModel;
import ru.example.beautysalon.data.models.ServiceImageModel;
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.data.repositories.ServicesRepository;

public class ServiceViewModel extends AndroidViewModel {

    private ServicesRepository servicesRepository;

    private MutableLiveData<List<ServiceImageModel>> browsLashesItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> facialItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> haircutItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> makeUpItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> manicureItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> waxingItems = new MutableLiveData<>();

    private MutableLiveData<List<PhotoModel>> browsLashesImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.brows_lashes1), new PhotoModel(R.drawable.brows_lashes2), new PhotoModel(R.drawable.brows_lashes3), new PhotoModel(R.drawable.brows_lashes4), new PhotoModel(R.drawable.brows_lashes5)));
    private MutableLiveData<List<PhotoModel>> facialImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.facial1), new PhotoModel(R.drawable.facial2), new PhotoModel(R.drawable.facial3), new PhotoModel(R.drawable.facial4), new PhotoModel(R.drawable.facial5)));
    private MutableLiveData<List<PhotoModel>> haircutImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.haircut1), new PhotoModel(R.drawable.haircut2), new PhotoModel(R.drawable.haircut3), new PhotoModel(R.drawable.haircut4), new PhotoModel(R.drawable.haircut5)));
    private MutableLiveData<List<PhotoModel>> makeUpImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.makeup1), new PhotoModel(R.drawable.makeup2), new PhotoModel(R.drawable.makeup3), new PhotoModel(R.drawable.makeup4), new PhotoModel(R.drawable.makeup5)));
    private MutableLiveData<List<PhotoModel>> manicureImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.manicure1), new PhotoModel(R.drawable.manicure2), new PhotoModel(R.drawable.manicure3), new PhotoModel(R.drawable.manicure4), new PhotoModel(R.drawable.manicure5)));
    private MutableLiveData<List<PhotoModel>> waxingImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.waxing1), new PhotoModel(R.drawable.waxing2), new PhotoModel(R.drawable.waxing3), new PhotoModel(R.drawable.waxing4), new PhotoModel(R.drawable.waxing5)));

    private MutableLiveData<String> typeService = new MutableLiveData<>();

    public ServiceViewModel(@NonNull Application application) {
        super(application);

        servicesRepository = new ServicesRepository(application);

    }



    public LiveData<List<ServiceImageModel>> getBrowsLashesItems() {

        servicesRepository.getDatabaseDataBrowsLashes().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.brows_lashes);

                serviceImageModels.add(serviceImageModel);
            }
            browsLashesItems.setValue(serviceImageModels);
        });

        return browsLashesItems;
    }

    public LiveData<List<ServiceImageModel>> getFacialItems() {

        servicesRepository.getDatabaseDataFacial().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.facial);

                serviceImageModels.add(serviceImageModel);
            }
            facialItems.setValue(serviceImageModels);
        });

        return facialItems;
    }

    public LiveData<List<ServiceImageModel>> getHaircutItems() {

        servicesRepository.getDatabaseDataHaircut().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.haircut);

                serviceImageModels.add(serviceImageModel);
            }
            haircutItems.setValue(serviceImageModels);
        });

        return haircutItems;
    }

    public LiveData<List<ServiceImageModel>> getMakeUpItems() {

        servicesRepository.getDatabaseDataMakeUp().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.make_up);

                serviceImageModels.add(serviceImageModel);
            }
            makeUpItems.setValue(serviceImageModels);
        });

        return makeUpItems;
    }

    public LiveData<List<ServiceImageModel>> getManicureItems() {

        servicesRepository.getDatabaseDataManicure().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.manicure);

                serviceImageModels.add(serviceImageModel);
            }
            manicureItems.setValue(serviceImageModels);
        });

        return manicureItems;
    }

    public LiveData<List<ServiceImageModel>> getWaxingItems() {

        servicesRepository.getDatabaseDataWaxing().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.waxing);

                serviceImageModels.add(serviceImageModel);
            }
            waxingItems.setValue(serviceImageModels);
        });

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

    public LiveData<String> getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService.setValue(typeService);
    }
}
