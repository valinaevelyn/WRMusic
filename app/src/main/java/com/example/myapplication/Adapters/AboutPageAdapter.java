package com.example.myapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.Fragments.AboutTabFragment;
import com.example.myapplication.Fragments.ContactTabFragment;

public class AboutPageAdapter extends FragmentStateAdapter {

    public AboutPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AboutTabFragment();
            case 1:
                return new ContactTabFragment();
            default:
                return new AboutTabFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
