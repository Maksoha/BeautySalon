package ru.example.beautysalon.ui.view.ViewPagerService;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.beautysalontest.databinding.FragmentWaxingBinding;

import java.util.Objects;

import ru.example.beautysalon.ui.adapters.CardSpecialist_RecyclerViewAdapter;
import ru.example.beautysalon.ui.viewModel.WaxingViewModel;


public class WaxingFragment extends Fragment {

    private FragmentWaxingBinding binding;

    private WaxingViewModel waxingViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        waxingViewModel = new ViewModelProvider(this).get(WaxingViewModel.class);
        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        binding.fragmentWaxingRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        binding.fragmentWaxingRecyclerView.setAdapter(new CardSpecialist_RecyclerViewAdapter());

        waxingViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), value -> {
            ((CardSpecialist_RecyclerViewAdapter) Objects.requireNonNull(binding.fragmentWaxingRecyclerView.getAdapter())).updateData(value);
        });

    }
}