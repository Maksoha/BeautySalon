package ru.example.beautysalon.ui.view.ViewPagerService;

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

import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.FragmentManicureBinding;

import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.SharedViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerService.ManicureServiceViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerSpecialist.ManicureViewModel;

public class ManicureServiceFragment extends Fragment implements ServiceAdapter.OnItemClickListener{

    private FragmentManicureBinding binding;
    private SharedViewModel sharedViewModel;
    private ManicureServiceViewModel manicureViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentManicureBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        manicureViewModel = new ViewModelProvider(this).get(ManicureServiceViewModel.class);
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
            sharedViewModel.setTypeService(selectedService.getType());
            Navigation.findNavController(view).navigate(R.id.action_navigation_booking_to_bookingFragment_SelectSpecialist);
        });
        binding.fragmentManicureRecyclerView.setAdapter(serviceAdapter);
        binding.fragmentManicureRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        manicureViewModel.getItemsService().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
    }
    @Override
    public void onItemClick(View view, int position) {
        Navigation.findNavController(view).navigate(R.id.action_navigation_booking_to_bookingFragment_SelectSpecialist);
    }
}