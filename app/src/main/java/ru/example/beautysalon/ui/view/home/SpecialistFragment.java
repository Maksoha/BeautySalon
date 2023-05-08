package ru.example.beautysalon.ui.view.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentSpecialistBinding;
import ru.example.beautysalon.ui.adapters.PhotoAdapter;
import ru.example.beautysalon.ui.adapters.ServiceAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistAdapter;
import ru.example.beautysalon.ui.viewModel.HomeViewModel;
import ru.example.beautysalon.ui.viewModel.SpecialistViewModel;


public class SpecialistFragment extends Fragment {

    private FragmentSpecialistBinding binding;
    private SpecialistViewModel viewModel;
    private SnapHelper snapHelper = new LinearSnapHelper();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SpecialistViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSpecialistBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        viewModel.getSpecialist().observe(getViewLifecycleOwner(), specialistModel -> {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(specialistModel.getSpeciality());
            binding.textAvatar.setText(specialistModel.getName().substring(0, 1));
            binding.name.setText(specialistModel.getName());
            binding.speciality.setText(specialistModel.getSpeciality());
            binding.description.setText("Опыт работы: " + specialistModel.getName().length() + " лет");

            PhotoAdapter photoAdapter = new PhotoAdapter(new PhotoAdapter.PhotoDiff());
            binding.recyclerViewPhotoGallery.setAdapter(photoAdapter);
            binding.recyclerViewPhotoGallery.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

            ServiceAdapter serviceAdapter = new ServiceAdapter(new ServiceAdapter.ServiceDiff());
            binding.recyclerViewServices.setAdapter(serviceAdapter);
            binding.recyclerViewServices.setLayoutManager(new LinearLayoutManager(getContext()));
            serviceAdapter.setOnItemClickListener((view1, position) -> {

            });
            switch (specialistModel.getSpeciality()) {
                case "Лашмейкер": {
                    viewModel.getBrowsLashesImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getBrowsLashesItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
                case "Косметолог": {
                    viewModel.getFacialImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getFacialItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
                case "Парикмахер": {
                    viewModel.getHaircutImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getHaircutItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
                case "Визажист": {
                    viewModel.getMakeUpImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getMakeUpItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
                case "Мастер ногтевого сервиса": {
                    viewModel.getManicureImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getManicureItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
                case "Мастер депиляции": {
                    viewModel.getWaxingImageResources().observe(getViewLifecycleOwner(), photoAdapter::submitList);
                    viewModel.getWaxingItems().observe(getViewLifecycleOwner(), serviceAdapter::submitList);
                    break;
                }
            }
            snapHelper.attachToRecyclerView(binding.recyclerViewPhotoGallery);

        });
        return view;
    }
}