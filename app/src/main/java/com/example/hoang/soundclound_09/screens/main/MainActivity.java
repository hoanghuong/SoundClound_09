package com.example.hoang.soundclound_09.screens.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hoang.soundclound_09.R;
import com.example.hoang.soundclound_09.mainhome.HomeAdapter;
import com.example.hoang.soundclound_09.mainhome.HomeFragment;
import com.example.hoang.soundclound_09.more.MoreFragment;
import com.example.hoang.soundclound_09.personal.MyMusicFragment;

public class MainActivity extends AppCompatActivity {

    private static final int[] TAB_ICONS = {
            R.drawable.ic_home,
            R.drawable.ic_person,
            R.drawable.ic_more
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        TabLayout tabLayout = findViewById(R.id.taplayout_main);
        ViewPager viewPager = findViewById(R.id.viewpager_main);
        initViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        initTapLayout(tabLayout);
    }

    private void initViewPager(ViewPager viewPager) {
        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager());
        homeAdapter.addFrament(new HomeFragment(), getString(R.string.app_home));
        homeAdapter.addFrament(new MyMusicFragment(), getString(R.string.app_personl));
        homeAdapter.addFrament(new MoreFragment(), getString(R.string.app_more));
        viewPager.setAdapter(homeAdapter);
    }

    private void initTapLayout(TabLayout tabLayout) {
        for (int position = 0; position < tabLayout.getTabCount(); position++) {
            tabLayout.getTabAt(position).setIcon(TAB_ICONS[position]);
        }
    }
}
