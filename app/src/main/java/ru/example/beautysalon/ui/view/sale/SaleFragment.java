package ru.example.beautysalon.ui.view.sale;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beautysalontest.databinding.FragmentSaleBinding;

import java.util.Objects;

import ru.example.beautysalon.ui.adapters.CardSale_RecyclerViewAdapter;
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
        binding.fragmentSaleRecyclerViewSale.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        binding.fragmentSaleRecyclerViewSale.setAdapter(new CardSale_RecyclerViewAdapter());

        saleViewModel.getItemsSale().observe(getViewLifecycleOwner(), value -> {
            if (!value.isEmpty()) {
                ((CardSale_RecyclerViewAdapter) Objects.requireNonNull(binding.fragmentSaleRecyclerViewSale.getAdapter())).updateData(value);
            }
        });
    }
}