package ru.example.beautysalon.ui.view.map;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentBottomSheetBinding;
import ru.example.beautysalon.databinding.FragmentMapsBinding;
import ru.example.beautysalon.ui.viewModel.MapsViewModel;


public class BottomSheetFragment extends BottomSheetDialogFragment {

    MapsViewModel viewModel;
    private FragmentBottomSheetBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MapsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false);

        viewModel.getAddress().observe(getViewLifecycleOwner(), address -> {
            binding.address.setText(address);
        });
        View view = binding.getRoot();

        return view;
    }
}