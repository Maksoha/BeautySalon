package ru.example.beautysalon.ui.view.ViewPagerSpecialist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


import com.example.beautysalontest.databinding.FragmentAllBinding;

import java.util.Objects;

import ru.example.beautysalon.ui.adapters.CardSpecialist_RecyclerViewAdapter;
import ru.example.beautysalon.ui.viewModel.AllViewModel;


public class AllFragment extends Fragment {

    private FragmentAllBinding binding;

    private AllViewModel allViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        allViewModel = new ViewModelProvider(this).get(AllViewModel.class);
        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        binding.fragmentAllRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        binding.fragmentAllRecyclerView.setAdapter(new CardSpecialist_RecyclerViewAdapter());

        allViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), value -> {
            ((CardSpecialist_RecyclerViewAdapter) Objects.requireNonNull(binding.fragmentAllRecyclerView.getAdapter())).updateData(value);
        });

    }
}