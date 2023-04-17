package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.FragmentBookingBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.example.beautysalon.ui.adapters.ServiceViewPagerAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistViewPagerAdapter;
import ru.example.beautysalon.ui.viewModel.BookingViewModel;


public class BookingFragment extends Fragment {
    private FragmentBookingBinding binding;

    private BookingViewModel viewModel;

    private ServiceViewPagerAdapter viewPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BookingViewModel.class);

        setTabLayoutService();
    }

    private void setTabLayoutService() {
        viewPagerAdapter = new ServiceViewPagerAdapter(requireActivity().getSupportFragmentManager(), requireActivity().getLifecycle());
        binding.fragmentBookingViewPager.setAdapter(viewPagerAdapter);
        viewModel.getItemsService().observe(getViewLifecycleOwner(), cardServiceModels -> {
            if (!cardServiceModels.isEmpty()) {
                new TabLayoutMediator(binding.fragmentBookingTabLayout, binding.fragmentBookingViewPager,
                        (tab, position) -> {
                            switch (position) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    tab.setText(cardServiceModels.get(position).getText());
                                    break;
                            }
                        }).attach();
            }
        });
    }
}