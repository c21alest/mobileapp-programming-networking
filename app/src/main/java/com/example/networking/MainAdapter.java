package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    // Skapar array som kommer från main activity
    List<Mountain> Tracks;
    public MainAdapter(List<Mountain> tracks) {
        Tracks = tracks;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Skapar en ny view för list_items som används för att presentera innehåller i recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        // Hämtar varje element i array
        holder.id.setText(Tracks.get(position).getID());
        holder.cost.setText(Tracks.get(position).getCost());
        holder.location.setText(Tracks.get(position).getLocation());
        holder.name.setText(Tracks.get(position).getName());
        holder.size.setText(Tracks.get(position).getSize());
        holder.type.setText(Tracks.get(position).getType());
        holder.img.setText(Tracks.get(position).getAuxdata().getImg());
        holder.wiki.setText(Tracks.get(position).getAuxdata().getWiki());
    }

    @Override
    public int getItemCount() {
        return Tracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView name;
        public TextView type;
        public TextView company;
        public TextView location;
        public TextView category;
        public TextView size;
        public TextView cost;
        public TextView wiki;
        public TextView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Kopplar variabel mot id i en layout
            id = itemView.findViewById(R.id.display_id);
            name = itemView.findViewById(R.id.display_name);
            type = itemView.findViewById(R.id.display_type);
            company = itemView.findViewById(R.id.display_company);
            location = itemView.findViewById(R.id.display_location);
            category = itemView.findViewById(R.id.display_category);
            size = itemView.findViewById(R.id.display_size);
            cost = itemView.findViewById(R.id.display_cost);
            wiki = itemView.findViewById(R.id.display_wiki);
            img = itemView.findViewById(R.id.display_img);
        }
    }
}
