package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.AddressModel;
import ru.example.beautysalon.databinding.FragmentBookingLocationSalonBinding;
import ru.example.beautysalon.ui.viewModel.BookingLocationSalonViewModel;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;


public class BookingFragmentLocationSalon extends Fragment {
    BookingLocationSalonViewModel viewModel;
    BookingConfirmViewModel bookingConfirmViewModel;
    FragmentBookingLocationSalonBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BookingLocationSalonViewModel.class);
        bookingConfirmViewModel = new ViewModelProvider(requireActivity()).get(BookingConfirmViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentBookingLocationSalonBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        viewModel.getItemsAddress().observe(getViewLifecycleOwner(), address -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.item_salon_location,
                    address.stream().map(AddressModel::getAddress).toArray(String[]::new));
            ((AutoCompleteTextView) binding.menuAddress.getEditText()).setAdapter(adapter);
        });
        ((AutoCompleteTextView) binding.menuAddress.getEditText()).
                setOnItemClickListener((parent, view1, position, id) ->
                        bookingConfirmViewModel.setAddress(parent.getItemAtPosition(position).toString()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}