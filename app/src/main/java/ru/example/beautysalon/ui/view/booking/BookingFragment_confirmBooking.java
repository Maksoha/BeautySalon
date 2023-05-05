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

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentBookingConfirmBookingBinding;
import ru.example.beautysalon.ui.viewModel.SharedViewModel;


public class BookingFragment_confirmBooking extends Fragment {

    private SharedViewModel sharedViewModel;
    private FragmentBookingConfirmBookingBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookingConfirmBookingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        sharedViewModel.getLocation().observe(getViewLifecycleOwner(), location ->{
            switch (location) {
                case "В салоне":
                    binding.CardViewServiceHeaderLocation.setText("Услуга в салоне");
                    sharedViewModel.getAddress().observe(getViewLifecycleOwner(), address -> {
                        binding.CardViewServiceAddress.setText(address);
                    });
                    break;
                case "На дому":
                    binding.CardViewServiceHeaderLocation.setText("Услуга на дому");
                    sharedViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
                        binding.CardViewServiceAddress.setText(address);
                    });
                    sharedViewModel.getApproach().observe(getViewLifecycleOwner(), approach -> {
                        binding.CardViewServiceAddress.append(", подъезд " + approach);
                    });
                    sharedViewModel.getApartment().observe(getViewLifecycleOwner(), apartment -> {
                        binding.CardViewServiceAddress.append(", кв. " + apartment);
                    });
                    break;
            }
        });
        sharedViewModel.getNameService().observe(getViewLifecycleOwner(), nameService -> {
            binding.CardViewServiceServiceName.setText(nameService);
        });
        sharedViewModel.getPriceService().observe(getViewLifecycleOwner(), priceService -> {
            binding.CardViewServiceServicePrice.setText(priceService + " рублей");
        });
        sharedViewModel.getNameSpecialist().observe(getViewLifecycleOwner(), nameSpecialist -> {
            binding.CardViewServiceTextAvatar.setText(nameSpecialist.substring(0, 1));
            binding.CardViewServiceSpecialistName.setText(nameSpecialist);
        });
        sharedViewModel.getSpecialitySpecialist().observe(getViewLifecycleOwner(), specialitySpecialist -> {
            binding.CardViewServiceSpecialistSpeciality.setText(specialitySpecialist);
        });
        sharedViewModel.getDate().observe(getViewLifecycleOwner(), date -> {
            binding.CardViewServiceDate.setText(date);
        });
        sharedViewModel.getTime().observe(getViewLifecycleOwner(), time -> {
            binding.CardViewServiceTime.setText(time + ", 1 час");
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel.getNameService().observe(getViewLifecycleOwner(), name -> {
            Log.d("check", name);
        });
        sharedViewModel.getNameSpecialist().observe(getViewLifecycleOwner(), time -> {
            Log.d("check", time);
        });

        binding.buttonConfirm.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.popBackStack(navController.getGraph().getStartDestinationId(), false);
        });




    }
}