package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<String> Tracks;

    public MainAdapter(ArrayList<String> tracks) {
        Tracks = tracks;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.textD.setText(Tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return Tracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textD = itemView.findViewById(R.id.display_text);
        }
    }
}
