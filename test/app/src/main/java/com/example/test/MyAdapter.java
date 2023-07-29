package com.example.test;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public MyAdapter(FragmentActivity fragmentActivity) {

        super(fragmentActivity);
    }

    public Fragment createFragment(int position) {

        return (PageFragment.newInstance(position));
    }

    @Override
    public int getItemCount() {

        return 10;
    }
}
