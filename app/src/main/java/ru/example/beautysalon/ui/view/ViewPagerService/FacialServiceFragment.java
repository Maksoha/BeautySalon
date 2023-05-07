package ru.example.beautysalon.ui.view.ViewPagerService;

import android.os.Bundle;
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
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.databinding.FragmentFacialBinding;
import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerService.FacialServiceViewModel;


public class FacialServiceFragment extends Fragment{
    private BookingConfirmViewModel bookingConfirmViewModel;
    private FragmentFacialBinding binding;

    private FacialServiceViewModel facialViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookingConfirmViewModel = new ViewModelProvider(requireActivity()).get(BookingConfirmViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFacialBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        facialViewModel = new ViewModelProvider(this).get(FacialServiceViewModel.class);
        setRecyclerView_service();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_service() {
        ServiceAdapter serviceAdapter = new ServiceAdapter(new ServiceAdapter.ServiceDiff());
        serviceAdapter.setOnItemClickListener((view, position) -> {
            ServiceModel selectedService = serviceAdapter.getCurrentList().get(position);
            bookingConfirmViewModel.setTypeService(selectedService.getType());
            bookingConfirmViewModel.setNameService(selectedService.getName());
            bookingConfirmViewModel.setPriceService(selectedService.getPrice());
            Navigation.findNavController(view).navigate(R.id.action_navigation_booking_to_bookingFragment_SelectSpecialist);
        });
        binding.fragmentFacialRecyclerView.setAdapter(serviceAdapter);
        binding.fragmentFacialRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        facialViewModel.getItemsService().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
    }

}