package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.fragments.MovieItemFragment;

public class MainActivity extends AppCompatActivity {



    int [] images={R.drawable.inception,R.drawable.mobilemovie,R.drawable.movie3};

    ViewPager pager;
    MyPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerAdapter= new MyPagerAdapter(getSupportFragmentManager(),images);
        pager=findViewById(R.id.vpMain);
        pager.setAdapter(viewPagerAdapter);



    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;
        int [] images;

        public MyPagerAdapter(FragmentManager fragmentManager, int[] images) {
            super(fragmentManager);
            this.images=images;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return images.length;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return MovieItemFragment.newInstance(images[position]);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return MovieItemFragment.newInstance(images[position]);
                case 2: // Fragment # 1 - This will show SecondFragment
                    return MovieItemFragment.newInstance(images[position]);
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}