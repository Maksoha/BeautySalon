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
import ru.example.beautysalon.data.models.SpecialistModel;
import ru.example.beautysalon.data.repositories.ServicesRepository;
import ru.example.beautysalon.data.repositories.SpecialistRepository;

public class ServiceViewModel extends AndroidViewModel {

    private ServicesRepository servicesRepository;
    private SpecialistRepository specialistRepository;
    private MutableLiveData<List<ServiceImageModel>> browsLashesServiceItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> facialIServicetems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> haircutServiceItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> makeUpServiceItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> manicureServiceItems = new MutableLiveData<>();
    private MutableLiveData<List<ServiceImageModel>> waxingServiceItems = new MutableLiveData<>();

    private LiveData<List<SpecialistModel>> browsLashesSpecialistItems;
    private LiveData<List<SpecialistModel>> facialSpecialistItems;
    private LiveData<List<SpecialistModel>> haircutSpecialistItems;
    private LiveData<List<SpecialistModel>> makeUpSpecialistItems;
    private LiveData<List<SpecialistModel>> manicureSpecialistItems;
    private LiveData<List<SpecialistModel>> waxingSpecialistItems;
    private LiveData<List<PhotoModel>> browsLashesImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.brows_lashes1), new PhotoModel(R.drawable.brows_lashes2), new PhotoModel(R.drawable.brows_lashes3), new PhotoModel(R.drawable.brows_lashes4), new PhotoModel(R.drawable.brows_lashes5)));
    private LiveData<List<PhotoModel>> facialImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.facial1), new PhotoModel(R.drawable.facial2), new PhotoModel(R.drawable.facial3), new PhotoModel(R.drawable.facial4), new PhotoModel(R.drawable.facial5)));
    private LiveData<List<PhotoModel>> haircutImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.haircut1), new PhotoModel(R.drawable.haircut2), new PhotoModel(R.drawable.haircut3), new PhotoModel(R.drawable.haircut4), new PhotoModel(R.drawable.haircut5)));
    private LiveData<List<PhotoModel>> makeUpImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.makeup1), new PhotoModel(R.drawable.makeup2), new PhotoModel(R.drawable.makeup3), new PhotoModel(R.drawable.makeup4), new PhotoModel(R.drawable.makeup5)));
    private LiveData<List<PhotoModel>> manicureImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.manicure1), new PhotoModel(R.drawable.manicure2), new PhotoModel(R.drawable.manicure3), new PhotoModel(R.drawable.manicure4), new PhotoModel(R.drawable.manicure5)));
    private LiveData<List<PhotoModel>> waxingImageResources = new MutableLiveData<>(Arrays.asList(new PhotoModel(R.drawable.waxing1), new PhotoModel(R.drawable.waxing2), new PhotoModel(R.drawable.waxing3), new PhotoModel(R.drawable.waxing4), new PhotoModel(R.drawable.waxing5)));

    private MutableLiveData<String> typeService = new MutableLiveData<>();

    public ServiceViewModel(@NonNull Application application) {
        super(application);

        servicesRepository = new ServicesRepository(application);
        specialistRepository = new SpecialistRepository(application);

        browsLashesSpecialistItems = specialistRepository.getDatabaseDataBrowsLashes();
        facialSpecialistItems = specialistRepository.getDatabaseDataFacial();
        haircutSpecialistItems = specialistRepository.getDatabaseDataHaircut();
        makeUpSpecialistItems = specialistRepository.getDatabaseDataMakeUp();
        manicureSpecialistItems = specialistRepository.getDatabaseDataManicure();
        waxingSpecialistItems = specialistRepository.getDatabaseDataWaxing();

    }

    public LiveData<List<SpecialistModel>> getBrowsLashesSpecialistItems() {
        return browsLashesSpecialistItems;
    }

    public LiveData<List<SpecialistModel>> getFacialSpecialistItems() {
        return facialSpecialistItems;
    }

    public LiveData<List<SpecialistModel>> getHaircutSpecialistItems() {
        return haircutSpecialistItems;
    }

    public LiveData<List<SpecialistModel>> getMakeUpSpecialistItems() {
        return makeUpSpecialistItems;
    }

    public LiveData<List<SpecialistModel>> getManicureSpecialistItems() {
        return manicureSpecialistItems;
    }

    public LiveData<List<SpecialistModel>> getWaxingSpecialistItems() {
        return waxingSpecialistItems;
    }

    public LiveData<List<ServiceImageModel>> getBrowsLashesItems() {

        servicesRepository.getDatabaseDataBrowsLashes().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.brows_lashes);

                serviceImageModels.add(serviceImageModel);
            }
            browsLashesServiceItems.setValue(serviceImageModels);
        });

        return browsLashesServiceItems;
    }

    public LiveData<List<ServiceImageModel>> getFacialItems() {

        servicesRepository.getDatabaseDataFacial().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.facial);

                serviceImageModels.add(serviceImageModel);
            }
            facialIServicetems.setValue(serviceImageModels);
        });

        return facialIServicetems;
    }

    public LiveData<List<ServiceImageModel>> getHaircutItems() {

        servicesRepository.getDatabaseDataHaircut().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.haircut);

                serviceImageModels.add(serviceImageModel);
            }
            haircutServiceItems.setValue(serviceImageModels);
        });

        return haircutServiceItems;
    }

    public LiveData<List<ServiceImageModel>> getMakeUpItems() {

        servicesRepository.getDatabaseDataMakeUp().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.make_up);

                serviceImageModels.add(serviceImageModel);
            }
            makeUpServiceItems.setValue(serviceImageModels);
        });

        return makeUpServiceItems;
    }

    public LiveData<List<ServiceImageModel>> getManicureItems() {

        servicesRepository.getDatabaseDataManicure().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.manicure);

                serviceImageModels.add(serviceImageModel);
            }
            manicureServiceItems.setValue(serviceImageModels);
        });

        return manicureServiceItems;
    }

    public LiveData<List<ServiceImageModel>> getWaxingItems() {

        servicesRepository.getDatabaseDataWaxing().observeForever(serviceModels -> {
            List<ServiceImageModel> serviceImageModels = new ArrayList<>();
            for (ServiceModel serviceModel : serviceModels) {
                ServiceImageModel serviceImageModel = new ServiceImageModel(serviceModel.getType(),
                        serviceModel.getName(), serviceModel.getPrice(), R.drawable.waxing);

                serviceImageModels.add(serviceImageModel);
            }
            waxingServiceItems.setValue(serviceImageModels);
        });

        return waxingServiceItems;
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
