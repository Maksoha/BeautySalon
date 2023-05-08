package ru.example.beautysalon.ui.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentServiceBinding;
import ru.example.beautysalon.ui.adapters.PhotoAdapter;
import ru.example.beautysalon.ui.adapters.ServiceImageAdapter;
import ru.example.beautysalon.ui.adapters.SpecialistCardAdapter;
import ru.example.beautysalon.ui.viewModel.ServiceViewModel;


public class ServiceFragment extends Fragment {
    private FragmentServiceBinding binding;
    private ServiceViewModel viewModel;
    private String typeService;
    private SnapHelper snapHelper = new LinearSnapHelper();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ServiceViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentServiceBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setRecyclerViewPhotoGallery();
        setRecyclerViewServices();
        setRecyclerViewSpecialists();
        return view;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setRecyclerViewSpecialists() {
        viewModel.getTypeService().observe(getViewLifecycleOwner(), typeService -> {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(typeService);

            SpecialistCardAdapter adapter = new SpecialistCardAdapter(new SpecialistCardAdapter.SpecialistCardDiff());
            binding.recyclerViewSpecialists.setAdapter(adapter);
            binding.recyclerViewSpecialists.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            if (typeService.equals(getResources().getString(R.string.browsLashes))) {
                viewModel.getBrowsLashesSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.haircut))) {
                viewModel.getHaircutSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.facial))) {
                viewModel.getFacialSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.makeUp))) {
                viewModel.getMakeUpSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.manicure))) {
                viewModel.getManicureSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.waxing))) {
                viewModel.getWaxingSpecialistItems().observe(getViewLifecycleOwner(), adapter::submitList);
            }
        });
        snapHelper.attachToRecyclerView(binding.recyclerViewServices);
    }

    private void setRecyclerViewServices() {
        viewModel.getTypeService().observe(getViewLifecycleOwner(), typeService -> {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(typeService);

        ServiceImageAdapter adapter = new ServiceImageAdapter(new ServiceImageAdapter.ServiceImageDiff());
        binding.recyclerViewServices.setAdapter(adapter);
        binding.recyclerViewServices.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        if (typeService.equals(getResources().getString(R.string.browsLashes))) {
            viewModel.getBrowsLashesItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        else if (typeService.equals(getResources().getString(R.string.haircut))) {
            viewModel.getHaircutItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        else if (typeService.equals(getResources().getString(R.string.facial))) {
            viewModel.getFacialItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        else if (typeService.equals(getResources().getString(R.string.makeUp))) {
            viewModel.getMakeUpItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        else if (typeService.equals(getResources().getString(R.string.manicure))) {
            viewModel.getManicureItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        else if (typeService.equals(getResources().getString(R.string.waxing))) {
            viewModel.getWaxingItems().observe(getViewLifecycleOwner(), adapter::submitList);
        }
        });
        snapHelper.attachToRecyclerView(binding.recyclerViewServices);
    }

    private void setRecyclerViewPhotoGallery() {
        viewModel.getTypeService().observe(getViewLifecycleOwner(), typeService -> {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(typeService);

            PhotoAdapter adapter = new PhotoAdapter(new PhotoAdapter.PhotoDiff());
            binding.recyclerViewPhotoGallery.setAdapter(adapter);
            binding.recyclerViewPhotoGallery.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            if (typeService.equals(getResources().getString(R.string.browsLashes))) {
                viewModel.getBrowsLashesImageResources().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.haircut))) {
                viewModel.getHaircutImageResources().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.facial))) {
                viewModel.getFacialImageResources().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.makeUp))) {
                viewModel.getMakeUpImageResources().observe(getViewLifecycleOwner(), adapter::submitList);

            }
            else if (typeService.equals(getResources().getString(R.string.manicure))) {
                viewModel.getManicureImageResources().observe(getViewLifecycleOwner(), adapter::submitList);
            }
            else if (typeService.equals(getResources().getString(R.string.waxing))) {
                viewModel.getWaxingImageResources().observe(getViewLifecycleOwner(), adapter::submitList);
            }
        });
        snapHelper.attachToRecyclerView(binding.recyclerViewPhotoGallery);

    }
}