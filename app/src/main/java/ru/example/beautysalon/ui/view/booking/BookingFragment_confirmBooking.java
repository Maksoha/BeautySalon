package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.FragmentBookingConfirmBookingBinding;


public class BookingFragment_confirmBooking extends Fragment {

    private FragmentBookingConfirmBookingBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBookingConfirmBookingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fragmentBookingConfirmBookingButtonConfirm.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_bookingFragment_confirmBooking_to_navigation_home);
        });
    }
}