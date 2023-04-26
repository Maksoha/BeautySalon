package ru.example.beautysalon.ui.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.beautysalontest.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import ru.example.beautysalon.ui.adapters.SaleAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistViewPagerAdapter;
import ru.example.beautysalon.ui.adapters.TypeServiceAdapter;
import ru.example.beautysalon.ui.viewModel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private SpecialistViewPagerAdapter viewPagerAdapter;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setRecyclerView_sale();
        setRecyclerView_service();
        setTabLayout_specialists();
    }


    private void setTabLayout_specialists() {
        viewPagerAdapter = new SpecialistViewPagerAdapter(requireActivity().getSupportFragmentManager(), requireActivity().getLifecycle());
        binding.fragmentHomeViewPager.setAdapter(viewPagerAdapter);
        homeViewModel.getTypeItemsService().observe(getViewLifecycleOwner(), cardServiceModels -> {
            if (!cardServiceModels.isEmpty()) {
                new TabLayoutMediator(binding.fragmentHomeTabLayout, binding.fragmentHomeViewPager,
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

    private void setRecyclerView_sale() {
        SaleAdapter saleAdapter = new SaleAdapter(new SaleAdapter.SaleDiff());
        binding.fragmentHomeRecyclerViewSales.setAdapter(saleAdapter);
        binding.fragmentHomeRecyclerViewSales.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        homeViewModel.getItemsSale().observe(getViewLifecycleOwner(), saleAdapter::submitList);
    }

    private void setRecyclerView_service() {
        TypeServiceAdapter typeServiceAdapter = new TypeServiceAdapter(new TypeServiceAdapter.TypeServiceDiff());
        binding.fragmentHomeRecyclerViewServices.setAdapter(typeServiceAdapter);

        binding.fragmentHomeRecyclerViewServices.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));

        homeViewModel.getTypeItemsServiceWithoutAll().observe(getViewLifecycleOwner(), typeServiceAdapter::submitList);

    }


}