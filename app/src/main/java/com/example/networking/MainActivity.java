package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";
    ArrayList<String> Tracks;
    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);


        Tracks = new ArrayList<>();
        Tracks.add("Circuit de Spa-Francorchamps");
        Tracks.add("Silverstone Circuit");
        Tracks.add("Laguna Seca Raceway");

        myRecyclerView = findViewById(R.id.recycler_view);

        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myAdapter = new MainAdapter(Tracks);
        myRecyclerView.setAdapter(myAdapter);
        myRecyclerView.setLayoutManager(myLayoutManager);

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
