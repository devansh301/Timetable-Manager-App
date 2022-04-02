package com.example.timemanagerapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.timemanagerapplication.Fragments.FutureTask;
import com.example.timemanagerapplication.Fragments.GoalStatus;
import com.example.timemanagerapplication.Fragments.PostpondedTask;

public class FragmentsAdapter extends FragmentPagerAdapter {


    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 1: return new GoalStatus();
           case 2: return new PostpondedTask();
           default: return new FutureTask();
       }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0){
            title = "Future Task";
        }
        if(position==1){
            title = "Goal Status";
        }
        if(position==2){
            title = "Unfinished Task";
        }
        return title;
//        return super.getPageTitle(position);
    }
}
