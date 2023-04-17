package ru.example.beautysalon.ui.view.ViewPagerSpecialist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.databinding.FragmentFacialBinding;

import java.util.Objects;

import ru.example.beautysalon.ui.adapters.CardSpecialist_RecyclerViewAdapter;
import ru.example.beautysalon.ui.viewModel.FacialViewModel;


public class FacialFragment extends Fragment {

    private FragmentFacialBinding binding;

    private FacialViewModel facialViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFacialBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        facialViewModel = new ViewModelProvider(this).get(FacialViewModel.class);
        setRecyclerView_specialistCard();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_specialistCard() {
        binding.fragmentFacialRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        binding.fragmentFacialRecyclerView.setAdapter(new CardSpecialist_RecyclerViewAdapter());

        facialViewModel.getItemsSpecialist().observe(getViewLifecycleOwner(), value -> {
            ((CardSpecialist_RecyclerViewAdapter) Objects.requireNonNull(binding.fragmentFacialRecyclerView.getAdapter())).updateData(value);
        });

    }
}