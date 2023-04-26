package ru.example.beautysalon.ui.view.booking;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.R;
import com.example.beautysalontest.databinding.FragmentBookingSelectDateBinding;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.util.concurrent.TimeUnit;

import ru.example.beautysalon.ui.adapters.TimeAdapter;
import ru.example.beautysalon.ui.viewModel.BookingSelectDateViewModel;


public class BookingFragment_SelectDate extends Fragment {
    private FragmentBookingSelectDateBinding binding;
    private BookingSelectDateViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(BookingSelectDateViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingSelectDateBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Выберите дату");

        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        long now = MaterialDatePicker.todayInUtcMilliseconds();
        constraintsBuilder.setStart(now);
        constraintsBuilder.setEnd(now + TimeUnit.DAYS.toMillis(14));
        constraintsBuilder.setValidator(DateValidatorPointForward.from(now));

        builder.setSelection(now);
        builder.setCalendarConstraints(constraintsBuilder.build());

        MaterialDatePicker<Long> picker = builder.build();

        picker.addOnPositiveButtonClickListener(selection -> {

        });

        picker.show(getChildFragmentManager(), picker.toString());

        binding.fragmentBookingSelectDateButton.setOnClickListener(v -> {
            picker.show(getChildFragmentManager(), picker.toString());
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerViewTime();
    }

    private void setRecyclerViewTime() {
        viewModel.getItemsTime().observe(getViewLifecycleOwner(), time -> {
            TimeAdapter timeAdapter =  new TimeAdapter(new TimeAdapter.ItemTimeDiff());
            timeAdapter.setOnItemClickListener(((view, position) -> {
                Navigation.findNavController(view).navigate(R.id.action_bookingFragment_SelectDate_to_bookingFragment_confirmBooking);
            }));
            binding.fragmentBookingSelectDateRecyclerViewTime.setAdapter(timeAdapter);
            binding.fragmentBookingSelectDateRecyclerViewTime.setLayoutManager(new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false));

            viewModel.getItemsTime().observe(getViewLifecycleOwner(), timeAdapter::submitList);

        });
    }
}