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

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorsViewHolder> {

Context context;
ArrayList<Actor> actors;

    public ActorsAdapter(Context context,ArrayList<Actor> actors) {
        this.context=context;
        this.actors=actors;

    }

    @NonNull
    @Override
    public ActorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_actors,parent,false);
        return  new ActorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorsViewHolder holder, int position) {

        holder.tvNameActor.setText(actors.get(position).getName());
        holder.ivActorPhoto.setImageResource(actors.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    class  ActorsViewHolder extends RecyclerView.ViewHolder{

        ImageView ivActorPhoto;
        TextView tvNameActor;


        public ActorsViewHolder(@NonNull View itemView) {
            super(itemView);

            ivActorPhoto=itemView.findViewById(R.id.ivActorPhoto);
            tvNameActor =itemView.findViewById(R.id.tvActorName);
        }
    }

}
