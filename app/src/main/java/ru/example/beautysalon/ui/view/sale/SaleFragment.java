package ru.example.beautysalon.ui.view.sale;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.databinding.FragmentSaleBinding;

import ru.example.beautysalon.ui.adapters.SaleAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.SaleViewModel;

public class SaleFragment extends Fragment {


    private SaleViewModel saleViewModel;

    private FragmentSaleBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSaleBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        saleViewModel = new ViewModelProvider(this).get(SaleViewModel.class);

        setRecyclerView_cardSale();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRecyclerView_cardSale() {
        SaleAdapter specialistAdapter = new SaleAdapter(new SaleAdapter.SaleDiff());
        binding.fragmentSaleRecyclerViewSale.setAdapter(specialistAdapter);
        binding.fragmentSaleRecyclerViewSale.setLayoutManager(new LinearLayoutManager(getContext()));
        saleViewModel.getItemsSale().observe(getViewLifecycleOwner(), specialistAdapter::submitList);
    }
}