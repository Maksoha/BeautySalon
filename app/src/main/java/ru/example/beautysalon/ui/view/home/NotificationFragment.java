package ru.example.beautysalon.ui.view.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentNotificationBinding;
import ru.example.beautysalon.ui.adapters.NotificationAdapter;
import ru.example.beautysalon.ui.viewModel.HomeNotificationViewModel;

public class NotificationFragment extends Fragment {

    FragmentNotificationBinding binding;
    HomeNotificationViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(HomeNotificationViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setRecyclerViewNotification();
        return view;
    }

    private void setRecyclerViewNotification() {
        NotificationAdapter adapter = new NotificationAdapter(new NotificationAdapter.NotificationDiff());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));

        viewModel.getAllItems().observe(getViewLifecycleOwner(), adapter::submitList);
    }
}