package com.example.tablayout;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> tabName = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
        fragmentList.add(new Contact());
        fragmentList.add(new Gallery());
        fragmentList.add(new Free());

        tabName.add("Contact");
        tabName.add("Gallery");
        tabName.add("Free");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabName.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return fragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return fragmentList.size();
    }

}