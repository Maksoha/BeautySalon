package ru.example.beautysalon.ui.view.profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import ru.example.beautysalon.R;
import ru.example.beautysalon.ui.viewModel.StartProfileViewModel;

public class StartProfileFragment extends Fragment {

    private StartProfileViewModel mViewModel;

    public static StartProfileFragment newInstance() {
        return new StartProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StartProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}