package ru.example.beautysalon.ui.view.ViewPagerService;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;


import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.databinding.FragmentHaircutBinding;
import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerService.HaircutServiceViewModel;


public class HaircutServiceFragment extends Fragment implements ServiceAdapter.OnItemClickListener{


    private FragmentHaircutBinding binding;
    private BookingConfirmViewModel bookingConfirmViewModel;
    private HaircutServiceViewModel haircutViewModel;
    private MutableLiveData<String> address_check = new MutableLiveData<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookingConfirmViewModel = new ViewModelProvider(requireActivity()).get(BookingConfirmViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHaircutBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        haircutViewModel = new ViewModelProvider(requireActivity()).get(HaircutServiceViewModel.class);
        bookingConfirmViewModel.getAddress().observe(getViewLifecycleOwner(), address-> {
            if (address != null) {
                address_check.setValue(address);
            }
        });
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
            if (address_check.getValue() != null) {
                if (!address_check.getValue().isEmpty()) {
                    Navigation.findNavController(view).navigate(R.id.action_navigation_booking_to_bookingFragment_SelectSpecialist);
                }
                else {
                    Toast.makeText(getContext(), "Введите адрес", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getContext(), "Введите адрес", Toast.LENGTH_SHORT).show();
            }
        });
        binding.fragmentHaircutRecyclerView.setAdapter(serviceAdapter);
        binding.fragmentHaircutRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        haircutViewModel.getItemsService().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
    }
    @Override
    public void onItemClick(View view, int position) {
        Navigation.findNavController(view).navigate(R.id.action_navigation_booking_to_bookingFragment_SelectSpecialist);
    }
}