package ru.example.beautysalon.ui.view.ViewPagerSpecialist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.databinding.FragmentHaircutBinding;

import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.viewPagerSpecialist.HaircutViewModel;


public class HaircutFragment extends Fragment {


    private FragmentHaircutBinding binding;

    private HaircutViewModel haircutViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        haircutViewModel = new ViewModelProvider(this).get(HaircutViewModel.class);
        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        SpecialistAdapter specialistAdapter = new SpecialistAdapter(new SpecialistAdapter.SpecialistDiff());
        specialistAdapter.setOnItemClickListener(((view, position) -> {
        }));
        binding.fragmentHaircutRecyclerView.setAdapter(specialistAdapter);
        binding.fragmentHaircutRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        haircutViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), specialistAdapter::submitList);

    }
}