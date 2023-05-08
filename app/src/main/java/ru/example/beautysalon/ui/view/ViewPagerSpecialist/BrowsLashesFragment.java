package ru.example.beautysalon.ui.view.ViewPagerSpecialist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentBrowsLashesBinding;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.SpecialistViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerSpecialist.BrowsLashesViewModel;


public class BrowsLashesFragment extends Fragment {

    private FragmentBrowsLashesBinding binding;
    private SpecialistViewModel specialistViewModel;
    private BrowsLashesViewModel browsLashesViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        browsLashesViewModel = new ViewModelProvider(this).get(BrowsLashesViewModel.class);
        specialistViewModel = new ViewModelProvider(requireActivity()).get(SpecialistViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBrowsLashesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        SpecialistAdapter specialistAdapter = new SpecialistAdapter(new SpecialistAdapter.SpecialistDiff());
        binding.fragmentBrowsLashesRecyclerView.setAdapter(specialistAdapter);
        specialistAdapter.setOnItemClickListener(((view, position) -> {
            specialistViewModel.setSpecialist(specialistAdapter.getCurrentList().get(position));
            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_specialistFragment);
        }));
        binding.fragmentBrowsLashesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        browsLashesViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
        browsLashesViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), specialistModels -> {
            Log.d("check", String.valueOf(specialistModels.size()));
        });
    }
}