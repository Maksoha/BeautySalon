package ru.example.beautysalon.ui.view.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.image.ImageProvider;

import ru.example.beautysalon.R;
import ru.example.beautysalon.databinding.FragmentMapsBinding;
import ru.example.beautysalon.ui.viewModel.MapsViewModel;


public class MapsFragment extends Fragment {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private FragmentMapsBinding binding;
    private MapsViewModel viewModel;
    private PlacemarkMapObject placemark1, placemark2, placemark3, placemark4;
    private MapObjectCollection mapObjects;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(MapsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MapKitFactory.initialize(requireContext());
        binding = FragmentMapsBinding.inflate(getLayoutInflater(), container, false);
        binding.mapView.getMap().move(
                new CameraPosition(new Point(55.75, 37.6), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);

        mapObjects = binding.mapView.getMap().getMapObjects().addCollection();
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Разрешение уже предоставлено, выполняйте действия для получения геопозиции
        } else {
            // Запрос разрешения у пользователя
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());

        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Создание объекта Point с использованием координат геопозиции
                Point myLocationPoint = new Point(latitude, longitude);

                // Добавление метки на карту
                PlacemarkMapObject myLocationPlacemark = mapObjects.addPlacemark(myLocationPoint);
                myLocationPlacemark.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.person32));
                myLocationPlacemark.setOpacity(0.8f);
                myLocationPlacemark.setDraggable(true);
            }
        }).addOnFailureListener(e -> {
            // Обработка ошибки при получении геопозиции
        });

        Point point1 = new Point(55.731612, 37.574947);
        placemark1 = mapObjects.addPlacemark(point1);
        placemark1.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.lotus48));
        placemark1.setOpacity(0.8f);
        placemark1.setDraggable(true);
        placemark1.addTapListener(mapObjectTapListener);


        Point point2 = new Point(55.670046, 37.480328);
        placemark2 = mapObjects.addPlacemark(point2);
        placemark2.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.lotus48));
        placemark2.setOpacity(0.8f);
        placemark2.setDraggable(true);
        placemark2.addTapListener(mapObjectTapListener);


        Point point3 = new Point(55.661430, 37.477049);
        placemark3 = mapObjects.addPlacemark(point3);
        placemark3.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.lotus48));
        placemark3.setOpacity(0.8f);
        placemark3.setDraggable(true);
        placemark3.addTapListener(mapObjectTapListener);

        Point point4 = new Point(55.794148, 37.701579);
        placemark4 = mapObjects.addPlacemark(point4);
        placemark4.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.lotus48));
        placemark4.setOpacity(0.8f);
        placemark4.setDraggable(true);
        placemark4.addTapListener(mapObjectTapListener);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private final MapObjectTapListener mapObjectTapListener = (mapObject, point) -> {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();

        if (mapObject == placemark1) {
            // Обработка нажатия на метку
            viewModel.setAddress("Малая Пироговская улица, 1с5");
            bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
        }
        else if (mapObject == placemark2) {
            // Обработка нажатия на метку
            viewModel.setAddress("проспект Вернадского, 78с4");
            bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
        }
        else if (mapObject == placemark3) {
            // Обработка нажатия на метку
            viewModel.setAddress("проспект Вернадского, 86");
            bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
        }
        else if (mapObject == placemark4) {
            // Обработка нажатия на метку
            viewModel.setAddress("улица Стромынка, 20");
            bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
        }
        return true;
    };

    @Override
    public void onStop() {
        binding.mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        binding.mapView.onStart();
    }
}