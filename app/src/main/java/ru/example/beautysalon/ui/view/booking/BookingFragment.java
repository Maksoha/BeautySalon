package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.example.beautysalon.R;
import ru.example.beautysalon.data.models.ServiceModel;
import ru.example.beautysalon.databinding.FragmentBookingBinding;
import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.adapters.ServiceViewPagerAdapter;
import ru.example.beautysalon.ui.view.MainActivity;
import ru.example.beautysalon.ui.viewModel.BookingViewModel;
import ru.example.beautysalon.ui.viewModel.SharedViewModel;


public class BookingFragment extends Fragment {
    private FragmentBookingBinding binding;
    private BookingViewModel viewModel;
    private SharedViewModel sharedViewModel;
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
        viewModel = new ViewModelProvider(this).get(BookingViewModel.class);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        binding.fragmentBookingButtonToggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                MaterialButton activeButton = group.findViewById(checkedId);
                sharedViewModel.setLocation(activeButton.getText().toString());
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