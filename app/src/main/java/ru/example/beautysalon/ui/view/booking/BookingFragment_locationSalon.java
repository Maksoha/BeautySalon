package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.FragmentBookingLocationSalonBinding;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.mapkit.search.SuggestItem;
import com.yandex.mapkit.search.SuggestOptions;
import com.yandex.mapkit.search.SuggestSession;
import com.yandex.runtime.Error;

import java.util.List;

import ru.example.beautysalon.ui.viewModel.BookingLocationSalonViewModel;


public class BookingFragment_locationSalon extends Fragment {

    private FragmentBookingLocationSalonBinding binding;

    private BookingLocationSalonViewModel viewModel;

    private SuggestSession suggestSession;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingLocationSalonBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        viewModel = new ViewModelProvider(this).get(BookingLocationSalonViewModel.class);
    }
}