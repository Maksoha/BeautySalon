package ru.example.beautysalon.ui.view.booking;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ru.example.beautysalon.databinding.FragmentBookingConfirmBookingBinding;
import ru.example.beautysalon.ui.viewModel.HomeNotificationViewModel;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;


public class BookingFragment_confirmBooking extends Fragment {
    private String service, specialist, date_time, address_card;
    private HomeNotificationViewModel homeNotificationViewModel;
    private BookingConfirmViewModel bookingConfirmViewModel;
    private FragmentBookingConfirmBookingBinding binding;
    private static final int REQUEST_CALENDAR_PERMISSION = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeNotificationViewModel = new ViewModelProvider(requireActivity()).get(HomeNotificationViewModel.class);
        bookingConfirmViewModel = new ViewModelProvider(requireActivity()).get(BookingConfirmViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookingConfirmBookingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        bookingConfirmViewModel.getLocation().observe(getViewLifecycleOwner(), location ->{
            switch (location) {
                case "В салоне":
                    binding.CardViewServiceHeaderLocation.setText("Услуга в салоне");
                    bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address -> {
                        binding.CardViewServiceAddress.setText(address);
                        address_card = address;
                    });
                    break;
                case "На дому":
                    binding.CardViewServiceHeaderLocation.setText("Услуга на дому");
                    bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
                        binding.CardViewServiceAddress.setText(address);
                        address_card = address;
                    });
                    bookingConfirmViewModel.getApproach().observe(getViewLifecycleOwner(), approach -> {
                        binding.CardViewServiceAddress.append(", подъезд " + approach);
                        address_card += ", подъезд " + approach;
                    });
                    bookingConfirmViewModel.getApartment().observe(getViewLifecycleOwner(), apartment -> {
                        binding.CardViewServiceAddress.append(", кв. " + apartment);
                        address_card += ", кв. " + apartment;
                    });
                    break;
            }
        });
        bookingConfirmViewModel.getNameService().observe(getViewLifecycleOwner(), nameService -> {
            binding.CardViewServiceServiceName.setText(nameService);
            service = nameService;
        });
        bookingConfirmViewModel.getPriceService().observe(getViewLifecycleOwner(), priceService -> {
            binding.CardViewServiceServicePrice.setText(priceService + " рублей");
        });
        bookingConfirmViewModel.getNameSpecialist().observe(getViewLifecycleOwner(), nameSpecialist -> {
            binding.CardViewServiceTextAvatar.setText(nameSpecialist.substring(0, 1));
            binding.CardViewServiceSpecialistName.setText(nameSpecialist);
            specialist = nameSpecialist;
        });
        bookingConfirmViewModel.getSpecialitySpecialist().observe(getViewLifecycleOwner(), specialitySpecialist -> {
            binding.CardViewServiceSpecialistSpeciality.setText(specialitySpecialist);
        });
        bookingConfirmViewModel.getDate().observe(getViewLifecycleOwner(), date -> {
            binding.CardViewServiceDate.setText(date);
            date_time = date + ", ";
        });
        bookingConfirmViewModel.getTime().observe(getViewLifecycleOwner(), time -> {
            binding.CardViewServiceTime.setText(time + ", 1 час");
            date_time += time;
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonConfirm.setOnClickListener(v -> {

            homeNotificationViewModel.addItem(getTime(), "Запись на услугу",
                    "Услуга: " + service + "\n" +
                            "Специалист: " + specialist + "\n" +
                            "Дата: " + date_time + "\n" +
                            "Адрес: " + binding.CardViewServiceAddress.getText());


            if (binding.textFieldName.getEditText().length() == 0) {
                binding.textFieldName.setError("Введите имя");
            }
            else if (binding.textFieldPhone.getEditText().length() != 12) {
                binding.textFieldPhone.setError("Введите номер телефона");
            }
            else {
                openCalendar();
                NavController navController = Navigation.findNavController(view);
                navController.popBackStack(navController.getGraph().getStartDestinationId(), false);
            }
        });


    }
    private void openCalendar() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CALENDAR)
                == PackageManager.PERMISSION_GRANTED) {
            // Разрешение предоставлено, открываем календарь
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);

            MutableLiveData<String> description = new MutableLiveData<>();

            bookingConfirmViewModel.getLocation().observe(getViewLifecycleOwner(), location->{
                if (location.equals("В салоне"))
                    intent.putExtra(CalendarContract.Events.TITLE, "Услуга в салоне");
                else if (location.equals("На дому"))
                    intent.putExtra(CalendarContract.Events.TITLE, "Услуга на дому");
            });
            bookingConfirmViewModel.getTypeService().observe(getViewLifecycleOwner(), typeService-> {
                description.setValue("Услуга : " + typeService);
            });
            bookingConfirmViewModel.getNameSpecialist().observe(getViewLifecycleOwner(), specialist -> {
                description.setValue(description.getValue() + "\nСпециалист : " + specialist );
            });

            intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getValue());
            bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, address);
            });

            MutableLiveData<Long> calendarTime = new MutableLiveData<>();

            bookingConfirmViewModel.getExactTime().observe(getViewLifecycleOwner(), exactTime-> {
                calendarTime.setValue(exactTime.getTime());
            });
            bookingConfirmViewModel.getTime().observe(getViewLifecycleOwner(), time -> {
                String pattern = "HH:mm";

                SimpleDateFormat sdf = new SimpleDateFormat(pattern);

                try {
                    Date date = sdf.parse(time);
                    calendarTime.setValue(calendarTime.getValue() + date.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendarTime.getValue());
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calendarTime.getValue() + 3600000);

            startActivity(intent);
        } else {
            // Разрешение не предоставлено, запросите разрешение у пользователя
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.READ_CALENDAR},
                    REQUEST_CALENDAR_PERMISSION);
        }
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CALENDAR)
                == PackageManager.PERMISSION_GRANTED) {
            // Разрешение предоставлено, открываем календарь
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);

            MutableLiveData<String> description = new MutableLiveData<>();

            bookingConfirmViewModel.getLocation().observe(getViewLifecycleOwner(), location->{
                if (location.equals("В салоне"))
                    intent.putExtra(CalendarContract.Events.TITLE, "Услуга в салоне");
                else if (location.equals("На дому"))
                    intent.putExtra(CalendarContract.Events.TITLE, "Услуга на дому");
            });
            bookingConfirmViewModel.getTypeService().observe(getViewLifecycleOwner(), typeService-> {
                description.setValue("Услуга : " + typeService);
            });
            bookingConfirmViewModel.getNameSpecialist().observe(getViewLifecycleOwner(), specialist -> {
                description.setValue(description.getValue() + "\nСпециалист : " + specialist );
            });

            intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getValue());
            bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, address);
            });

            MutableLiveData<Long> calendarTime = new MutableLiveData<>();

            bookingConfirmViewModel.getExactTime().observe(getViewLifecycleOwner(), exactTime-> {
                calendarTime.setValue(exactTime.getTime());
            });
            bookingConfirmViewModel.getTime().observe(getViewLifecycleOwner(), time -> {
                String pattern = "HH:mm";

                SimpleDateFormat sdf = new SimpleDateFormat(pattern);

                try {
                    Date date = sdf.parse(time);
                    calendarTime.setValue(calendarTime.getValue() + date.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendarTime.getValue());
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calendarTime.getValue() + 3600000);

            startActivity(intent);
        }
    }

    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String currentTime = dateFormat.format(calendar.getTime());
        dateFormat = new SimpleDateFormat("d MMMM", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());
        return (currentDate + ", " + currentTime);
    }
}