package ru.example.beautysalon.data.models;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import ru.example.beautysalon.ui.view.ViewPagerService.AllFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.BrowsLashesFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.FacialFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.HaircutFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.MakeUpFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.ManicureFragment;
import ru.example.beautysalon.ui.view.ViewPagerService.WaxingFragment;

public class TabServiceModel {

    public ArrayList<Fragment> getFragmentArrayList() {
        return fragmentArrayList;
    }

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public TabServiceModel() {
        fragmentArrayList.add(new AllFragment());
        fragmentArrayList.add(new BrowsLashesFragment());
        fragmentArrayList.add(new FacialFragment());
        fragmentArrayList.add(new HaircutFragment());
        fragmentArrayList.add(new MakeUpFragment());
        fragmentArrayList.add(new ManicureFragment());
        fragmentArrayList.add(new WaxingFragment());
    }
}
