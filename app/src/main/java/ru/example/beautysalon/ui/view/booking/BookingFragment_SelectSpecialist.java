package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;


import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.SpecialistModel;
import ru.example.beautysalon.databinding.FragmentBookingSelectSpecialistBinding;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.BookingSelectSpecialistViewModel;
import ru.example.beautysalon.ui.viewModel.SharedViewModel;

public class BookingFragment_SelectSpecialist extends Fragment {
    private SharedViewModel sharedViewModel;
    private BookingSelectSpecialistViewModel viewModel;
    private FragmentBookingSelectSpecialistBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(BookingSelectSpecialistViewModel.class);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingSelectSpecialistBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerViewSpecialist();
        sharedViewModel.getLocation().observe(getViewLifecycleOwner(), location ->{
            Log.d("check", location);
        });
    }

    private void setRecyclerViewSpecialist() {
        sharedViewModel.getTypeService().observe(getViewLifecycleOwner(), service -> {
            SpecialistAdapter specialistAdapter = new SpecialistAdapter(new SpecialistAdapter.SpecialistDiff());
            specialistAdapter.setOnItemClickListener(((view, position) -> {
                SpecialistModel specialistModel = specialistAdapter.getCurrentList().get(position);
                sharedViewModel.setNameSpecialist(specialistModel.getName());
                sharedViewModel.setSpecialitySpecialist(specialistModel.getSpeciality());
                Navigation.findNavController(view).navigate(R.id.action_bookingFragment_SelectSpecialist_to_bookingFragment_SelectDate);
            }));
            binding.fragmentBookingSelectSpecialistRecyclerView.setAdapter(specialistAdapter);
            binding.fragmentBookingSelectSpecialistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            switch (service) {
                case "Брови/Ресницы":
                    viewModel.getItemsSpecialistBrowsLashes().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
                case "Косметология":
                    viewModel.getItemsSpecialistFacial().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
                case "Парикмахер":
                    viewModel.getItemsSpecialistHaircut().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
                case "Визаж":
                    viewModel.getItemsSpecialistMakeUp().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
                case "Маникюр/Педикюр":
                    viewModel.getItemsSpecialistManicure().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
                case "Депиляция":
                    viewModel.getItemsSpecialistWaxing().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
                    break;
            }
        });

    }
}