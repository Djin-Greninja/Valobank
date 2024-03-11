package com.example.valobank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo,bg;
    TextView bank_name,tagline;

    private static final int NUM_PAGES=3;
    private ViewPager viewPager;
    private ScreenSlidePageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo = findViewById(R.id.bank_logo);
        bank_name = findViewById(R.id.bank_name);
        tagline = findViewById(R.id.tagline);
        bg= findViewById(R.id.int_bg);

        viewPager=findViewById(R.id.pager);
        pageAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        bg.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(3000).setDuration(1000).setStartDelay(4000);
        bank_name.animate().translationY(3000).setDuration(1000).setStartDelay(4000);
        tagline.animate().translationY(3000).setDuration(1000).setStartDelay(4000);

    }

    private class ScreenSlidePageAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoardingScreen1 tab1= new OnBoardingScreen1();
                    return tab1;
                case 1:
                    OnBoardingScreen2 tab2= new OnBoardingScreen2();
                    return tab2;
                case 2:
                    OnBoardingScreen3 tab3= new OnBoardingScreen3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}