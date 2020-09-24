package app.silkroad.moviesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.models.Actor;
import app.silkroad.moviesapp.models.Movies;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

Context context;
ArrayList<Movies> movies;

    public MoviesAdapter(Context context, ArrayList<Movies> movies) {
        this.context=context;
        this.movies=movies;

    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movies,parent,false);
        return  new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        holder.tvNameActor.setText(movies.get(position).getName());
        holder.ivActorPhoto.setImageResource(movies.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class  MoviesViewHolder extends RecyclerView.ViewHolder{

        ImageView ivActorPhoto;
        TextView tvNameActor;


        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            ivActorPhoto=itemView.findViewById(R.id.ivMoviePhoto);
            tvNameActor =itemView.findViewById(R.id.tvMovieName);
        }
    }

}
