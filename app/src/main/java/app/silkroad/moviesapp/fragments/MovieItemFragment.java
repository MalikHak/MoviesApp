package app.silkroad.moviesapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.silkroad.moviesapp.R;


public class MovieItemFragment extends Fragment {

ImageView imageViewMovie;
static int photo;

    public MovieItemFragment() {
        // Required empty public constructor
    }


    public static MovieItemFragment newInstance(int photoId) {
        MovieItemFragment fragment = new MovieItemFragment();

    photo=photoId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_view_pager, container, false);

        imageViewMovie=view.findViewById(R.id.ivImageMovie);

        imageViewMovie.setImageResource(photo);

    return view;

    }
}