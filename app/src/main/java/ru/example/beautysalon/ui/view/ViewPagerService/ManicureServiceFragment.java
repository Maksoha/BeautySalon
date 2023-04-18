package ru.example.beautysalon.ui.view.ViewPagerService;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.beautysalontest.databinding.FragmentManicureBinding;

import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.viewPagerService.ManicureServiceViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerSpecialist.ManicureViewModel;

public class ManicureServiceFragment extends Fragment {

    private FragmentManicureBinding binding;

    private ManicureServiceViewModel manicureViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        ServiceAdapter serviceAdapter = new ServiceAdapter(new ServiceAdapter.ServiceDiff());
        binding.fragmentManicureRecyclerView.setAdapter(serviceAdapter);
        binding.fragmentManicureRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        manicureViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), serviceAdapter::submitList);

    }
}