package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentBookingBinding;
import ru.example.beautysalon.ui.adapters.ServiceViewPagerAdapter;
import ru.example.beautysalon.ui.viewModel.BookingViewModel;
import ru.example.beautysalon.ui.viewModel.BookingConfirmViewModel;


public class BookingFragment extends Fragment {
    private FragmentBookingBinding binding;
    private BookingViewModel viewModel;
    private BookingConfirmViewModel bookingConfirmViewModel;
    private ServiceViewPagerAdapter viewPagerAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookingConfirmViewModel = new ViewModelProvider(requireActivity()).get(BookingConfirmViewModel.class);
        viewModel = new ViewModelProvider(this).get(BookingViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingBinding.inflate(getLayoutInflater());


        binding.fragmentBookingButtonToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                MaterialButton activeButton = group.findViewById(checkedId);
                bookingConfirmViewModel.setLocation(activeButton.getText().toString());
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                switch (checkedId) {
                    case R.id.fragment_booking_button_selected_at_the_salon:
                        navController.navigate(R.id.bookingFragmentLocationSalon);
                        break;
                    case R.id.fragment_booking_button_selected_at_home:
                        navController.navigate(R.id.bookingFragmentLocationHome);
                        break;
                }
            }

        });

        setTabLayoutService();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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