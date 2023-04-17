package ru.example.beautysalon.data.models;

import androidx.fragment.app.Fragment;

import ru.example.beautysalon.ui.view.ViewPagerSpecialist.AllFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.BrowsLashesFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.FacialFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.HaircutFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.MakeUpFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.ManicureFragment;
import ru.example.beautysalon.ui.view.ViewPagerSpecialist.WaxingFragment;

import java.util.ArrayList;

public class TabSpecialistModel {

    public ArrayList<Fragment> getFragmentArrayList() {
        return fragmentArrayList;
    }

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public TabSpecialistModel() {
        fragmentArrayList.add(new AllFragment());
        fragmentArrayList.add(new BrowsLashesFragment());
        fragmentArrayList.add(new FacialFragment());
        fragmentArrayList.add(new HaircutFragment());
        fragmentArrayList.add(new MakeUpFragment());
        fragmentArrayList.add(new ManicureFragment());
        fragmentArrayList.add(new WaxingFragment());
    }

}
