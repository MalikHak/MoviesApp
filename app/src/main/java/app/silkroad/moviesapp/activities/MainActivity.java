package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.adapters.ActorsAdapter;
import app.silkroad.moviesapp.fragments.MovieItemFragment;
import app.silkroad.moviesapp.models.Actor;

public class MainActivity extends AppCompatActivity {


    ArrayList<Actor> listActors=new ArrayList<>();

    int [] images={R.drawable.inception,R.drawable.inception,R.drawable.inception};

    RecyclerView rvAcctors;

    RecyclerView.LayoutManager layoutManager;
    ViewPager pager;
    MyPagerAdapter viewPagerAdapter;

    ActorsAdapter actorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Actor actor1=new Actor("Tom Hardy",90,R.drawable.tom);
        Actor actor2=new Actor("Tom Cruiz",90,R.drawable.imt);
        Actor actor3=new Actor("Tom Hanks",90,R.drawable.tomc);
        Actor actor4=new Actor("Tim Cook",90,R.drawable.nat);
        Actor actor5=new Actor("Tom Hardy",90,R.drawable.tom);
        Actor actor6=new Actor("Tom Cruiz",90,R.drawable.imt);
        Actor actor7=new Actor("Tom Hanks",90,R.drawable.tomc);
        Actor actor8=new Actor("Tim Cook",90,R.drawable.nat);


        listActors.add(actor1);
        listActors.add(actor2);
        listActors.add(actor3);
        listActors.add(actor4);
        listActors.add(actor5);
        listActors.add(actor6);
        listActors.add(actor7);
        listActors.add(actor8);


        actorsAdapter= new ActorsAdapter(MainActivity.this,listActors);

        viewPagerAdapter= new MyPagerAdapter(getSupportFragmentManager(),images);
        pager=findViewById(R.id.vpMain);
        rvAcctors= findViewById(R.id.rvActors);
        layoutManager= new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);



        rvAcctors.setAdapter(actorsAdapter);
        rvAcctors.setLayoutManager(layoutManager);
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


            Log.d("data", "getItem: "+position);

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