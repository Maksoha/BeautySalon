package ru.example.beautysalon.ui.view.sale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import ru.example.beautysalon.databinding.FragmentSaleBinding;
import ru.example.beautysalon.ui.adapters.SaleAdapter;
import ru.example.beautysalon.ui.adapters.SaleCenteredAdapter;
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
        SaleCenteredAdapter saleAdapter = new SaleCenteredAdapter(new SaleCenteredAdapter.SaleDiff());
        binding.fragmentSaleRecyclerViewSale.setAdapter(saleAdapter);
        binding.fragmentSaleRecyclerViewSale.setLayoutManager(new LinearLayoutManager(getContext()));
        saleViewModel.getItemsSale().observe(getViewLifecycleOwner(), saleAdapter::submitList);
    }
}