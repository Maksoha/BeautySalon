package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.example.beautysalon.databinding.FragmentBookingConfirmBookingBinding;
import ru.example.beautysalon.ui.viewModel.HomeNotificationViewModel;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;


public class BookingFragment_confirmBooking extends Fragment {
    private String service, specialist, date_time;
    private HomeNotificationViewModel homeNotificationViewModel;
    private BookingConfirmViewModel bookingConfirmViewModel;
    private FragmentBookingConfirmBookingBinding binding;

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
                    });
                    break;
                case "На дому":
                    binding.CardViewServiceHeaderLocation.setText("Услуга на дому");
                    bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
                        binding.CardViewServiceAddress.setText(address);
                    });
                    bookingConfirmViewModel.getApproach().observe(getViewLifecycleOwner(), approach -> {
                        binding.CardViewServiceAddress.append(", подъезд " + approach);
                    });
                    bookingConfirmViewModel.getApartment().observe(getViewLifecycleOwner(), apartment -> {
                        binding.CardViewServiceAddress.append(", кв. " + apartment);
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
                            "Дата: " + date_time);
            NavController navController = Navigation.findNavController(view);
            navController.popBackStack(navController.getGraph().getStartDestinationId(), false);
        });




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