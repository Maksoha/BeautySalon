package ru.example.beautysalon.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.example.beautysalon.data.models.NotificationModel;
import ru.example.beautysalon.data.repositories.NotificationRepository;

public class HomeNotificationViewModel extends AndroidViewModel {

    private NotificationRepository notificationRepository;
    private LiveData<List<NotificationModel>> notificationItems;

    public HomeNotificationViewModel(@NonNull Application application) {
        super(application);

        notificationRepository = new NotificationRepository(application);
        notificationItems = notificationRepository.getDatabaseData();
    }

    public LiveData<List<NotificationModel>> getAllItems() {
        return notificationItems;
    }

    public void addItem(String date, String title, String description) {
        notificationRepository.addNewItems(new NotificationModel(date, title, description));
    }
}
