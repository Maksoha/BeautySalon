package ru.example.beautysalon.ui.view.ViewPagerSpecialist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentWaxingBinding;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.SpecialistViewModel;
import ru.example.beautysalon.ui.viewModel.viewPagerSpecialist.WaxingViewModel;


public class WaxingFragment extends Fragment {

    private FragmentWaxingBinding binding;

    private WaxingViewModel waxingViewModel;
    private SpecialistViewModel specialistViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        waxingViewModel = new ViewModelProvider(this).get(WaxingViewModel.class);
        specialistViewModel = new ViewModelProvider(requireActivity()).get(SpecialistViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWaxingBinding.inflate(inflater, container, false);
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
        specialistAdapter.setOnItemClickListener(((view, position) -> {
            specialistViewModel.setSpecialist(specialistAdapter.getCurrentList().get(position));
            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_specialistFragment);
        }));
        binding.fragmentWaxingRecyclerView.setAdapter(specialistAdapter);
        binding.fragmentWaxingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        waxingViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
    }
}