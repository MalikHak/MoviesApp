package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.adapters.ActorsAdapter;
import app.silkroad.moviesapp.adapters.MoviesAdapter;
import app.silkroad.moviesapp.fragments.MovieItemFragment;
import app.silkroad.moviesapp.models.Actor;
import app.silkroad.moviesapp.models.Movies;
import app.silkroad.moviesapp.utilities.SessionManager;
import app.silkroad.moviesapp.views.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    ArrayList<Actor> listActors=new ArrayList<>();
    ArrayList<Movies> listMovies=new ArrayList<>();

    int [] images={R.drawable.inception,R.drawable.inception,R.drawable.inception};

    RecyclerView rvAcctors;
    RecyclerView rvMovies;
    SessionManager sessionManager;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager layoutManager2;
    ViewPager pager;
    MyPagerAdapter viewPagerAdapter;

    CircleImageView ivProfile;
    ActorsAdapter actorsAdapter;
    MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager=new SessionManager(MainActivity.this);

        sessionManager.setHighScore(1000+"");

        ivProfile=findViewById(R.id.ivProfileUser);

        ivProfile.setOnClickListener(this);


        Actor actor1=new Actor("Tom Hardy",90,R.drawable.imt);
        Actor actor2=new Actor("Tom Cruiz",90,R.drawable.imt);
        Actor actor3=new Actor("Tom Hanks",90,R.drawable.imt);
        Actor actor4=new Actor("Tim Cook",90,R.drawable.imt);
        Actor actor5=new Actor("Tom Hardy",90,R.drawable.imt);
        Actor actor6=new Actor("Tom Cruiz",90,R.drawable.imt);
        Actor actor7=new Actor("Tom Hanks",90,R.drawable.imt);
        Actor actor8=new Actor("Tim Cook",90,R.drawable.imt);






        listActors.add(actor1);
        listActors.add(actor2);
        listActors.add(actor3);
        listActors.add(actor4);
        listActors.add(actor5);
        listActors.add(actor6);
        listActors.add(actor7);
        listActors.add(actor8);


        Movies movies1=new Movies("Afghanite",90,R.drawable.tom);
        Movies movies2=new Movies("Imitation",90,R.drawable.tomc);
        Movies movies3=new Movies("Tom Cruiz",90,R.drawable.tom);
        Movies movies4=new Movies("Inception",90,R.drawable.tomc);
        Movies movies5=new Movies("Natale",90,R.drawable.imt);






        listMovies.add(movies1);
        listMovies.add(movies2);
        listMovies.add(movies3);
        listMovies.add(movies4);
        listMovies.add(movies5);





        actorsAdapter= new ActorsAdapter(MainActivity.this,listActors);
        moviesAdapter= new MoviesAdapter(MainActivity.this,listMovies);

        viewPagerAdapter= new MyPagerAdapter(getSupportFragmentManager(),images);
        pager=findViewById(R.id.vpMain);
        rvAcctors= findViewById(R.id.rvActors);
        rvMovies= findViewById(R.id.rvMovies);
        layoutManager= new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager2= new GridLayoutManager(MainActivity.this,2);



        rvAcctors.setAdapter(actorsAdapter);
        rvAcctors.setLayoutManager(layoutManager);
        pager.setAdapter(viewPagerAdapter);


        rvMovies.setAdapter(moviesAdapter );
        rvMovies.setLayoutManager(layoutManager2);
        pager.setAdapter(viewPagerAdapter);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.ivProfileUser:
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            break;
        }
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