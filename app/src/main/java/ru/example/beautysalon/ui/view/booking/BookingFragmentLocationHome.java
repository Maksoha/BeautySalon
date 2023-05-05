package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentBookingLocationHomeBinding;
import ru.example.beautysalon.ui.viewModel.SharedViewModel;


public class BookingFragmentLocationHome extends Fragment {
    SharedViewModel sharedViewModel;
    FragmentBookingLocationHomeBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingLocationHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.address.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setAddress(String.valueOf(binding.address.getEditText().getText()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.approach.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setApproach(Integer.parseInt(String.valueOf(binding.approach.getEditText().getText())));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.intercom.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setIntercom(Integer.parseInt(String.valueOf(binding.intercom.getEditText().getText())));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.apartment.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setApartment(Integer.parseInt(String.valueOf(binding.apartment.getEditText().getText())));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.floor.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedViewModel.setFloor(Integer.parseInt(String.valueOf(binding.floor.getEditText().getText())));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}