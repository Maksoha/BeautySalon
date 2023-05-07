package ru.example.beautysalon.ui.view.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.TypeServiceModel;
import ru.example.beautysalon.databinding.FragmentServiceBinding;
import ru.example.beautysalon.ui.viewModel.ServiceViewModel;


public class ServiceFragment extends Fragment {

    FragmentServiceBinding binding;
    ServiceViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ServiceViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentServiceBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        viewModel.getTypeService().observe(getViewLifecycleOwner(), typeService -> {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(typeService);
        });
        return view;
    }

}