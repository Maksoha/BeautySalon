package ru.example.beautysalon.data.models;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import ru.example.beautysalon.ui.view.ViewPagerService.AllServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.BrowsLashesServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.FacialServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.HaircutServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.MakeUpServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.ManicureServiceFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.WaxingServiceFragment;

public class TabServiceModel {

    public ArrayList<Fragment> getFragmentArrayList() {
        return fragmentArrayList;
    }

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public TabServiceModel() {
        fragmentArrayList.add(new AllServiceFragment());
        fragmentArrayList.add(new BrowsLashesServiceFragment());
        fragmentArrayList.add(new FacialServiceFragment());
        fragmentArrayList.add(new HaircutServiceFragment());
        fragmentArrayList.add(new MakeUpServiceFragment());
        fragmentArrayList.add(new ManicureServiceFragment());
        fragmentArrayList.add(new WaxingServiceFragment());
    }
}
