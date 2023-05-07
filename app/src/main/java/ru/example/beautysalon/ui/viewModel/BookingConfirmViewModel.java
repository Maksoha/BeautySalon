package ru.example.beautysalon.ui.viewModel;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class BookingConfirmViewModel extends ViewModel {
    private MutableLiveData<Boolean> selectAddress = new MutableLiveData<>(false);
    private MutableLiveData<Integer> approach = new MutableLiveData<>();
    private MutableLiveData<Integer> intercom = new MutableLiveData<>();
    private MutableLiveData<Integer> apartment = new MutableLiveData<>();
    private MutableLiveData<Integer> floor = new MutableLiveData<>();
    private MutableLiveData<String> typeService = new MutableLiveData<>();
    private MutableLiveData<String> nameService = new MutableLiveData<>();
    private MutableLiveData<String> date = new MutableLiveData<>();
    private MutableLiveData<String> time = new MutableLiveData<>();
    private MutableLiveData<Integer> priceService = new MutableLiveData<>();
    private MutableLiveData<String> nameSpecialist = new MutableLiveData<>();
    private MutableLiveData<String> specialitySpecialist = new MutableLiveData<>();
    private MutableLiveData<String> location = new MutableLiveData<>("В салоне");

    private MutableLiveData<String> address = new MutableLiveData<>();
    public LiveData<Boolean> getSelectAddress() {return selectAddress;}
    public LiveData<Integer> getApproach() {
        return approach;
    }
    public LiveData<Integer> getIntercom() {
        return intercom;
    }
    public LiveData<Integer> getApartment() {
        return apartment;
    }
    public LiveData<Integer> getFloor() {
        return floor;
    }
    public LiveData<String> getAddress() {return address;}
    public LiveData<String> getDate() {
        return date;
    }

    public LiveData<String> getTime() {
        return time;
    }

    public LiveData<String> getNameSpecialist() {
        return nameSpecialist;
    }

    public LiveData<String> getSpecialitySpecialist() {
        return specialitySpecialist;
    }

    public LiveData<String> getLocation() {
        return location;
    }

    public LiveData<String> getTypeService() {
        return typeService;
    }
    public LiveData<String> getNameService() {
        return nameService;
    }

    public LiveData<Integer> getPriceService() {
        return priceService;
    }
    public void setSelectAddress(Boolean selectAddress) {this.selectAddress.setValue(selectAddress);}
    public void setApproach(Integer approach) {this.approach.setValue(approach);}
    public void setIntercom(Integer intercom) {this.intercom.setValue(intercom);}
    public void setApartment(Integer apartment) {this.apartment.setValue(apartment);}
    public void setFloor(Integer floor) {this.floor.setValue(floor);}
    public void setAddress(String address) {this.address.setValue(address);}
    public void setTypeService(String typeService) {
        this.typeService.setValue(typeService);
    }

    public void setNameService(String nameService) {this.nameService.setValue(nameService);}

    public void setPriceService(Integer priceService) {this.priceService.setValue(priceService);}

    public void setLocation(String location) {this.location.setValue(location);}
    public void setSpecialitySpecialist (String speciality) {specialitySpecialist.setValue(speciality);}
    public void setNameSpecialist(String name) {nameSpecialist.setValue(name);}
    public void setDate(String date) {this.date.setValue(date);}
    public void setTime(String time) {this.time.setValue(time);}


}
