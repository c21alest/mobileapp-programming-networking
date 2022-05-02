package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    ArrayList<String> Tracks;
    ArrayList<String> MountainsA;
    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager myLayoutManager;

    private Mountain[] mountains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("==>", json);

        Gson gson = new Gson();
        mountains = gson.fromJson(json, Mountain[].class);

        MountainsA = new ArrayList<>();

        for (int i = 0; i < mountains.length; i++) {
            String id = mountains[i].getID();
            MountainsA.add(id);
            String name = mountains[i].getName();
            MountainsA.add(name);
            String type = mountains[i].getType();
            MountainsA.add(type);
            String company = mountains[i].getCompany();
            MountainsA.add(company);
            String location = mountains[i].getLocation();
            MountainsA.add(location);
            String category = mountains[i].getCategory();
            MountainsA.add(category);
            String size = mountains[i].getSize();
            MountainsA.add(size);
            String cost = mountains[i].getCost();
            MountainsA.add(cost);
            Log.d("==>","Namn: " + id);
            Log.d("==>","Namn: " + name);
            Log.d("==>","Namn: " + type);
            Log.d("==>","Namn: " + company);
            Log.d("==>","Namn: " + location);
            Log.d("==>","Namn: " + category);
            Log.d("==>","Namn: " + size);
            Log.d("==>","Namn: " + cost);

        }

        while (MountainsA.remove(null)) {}

        Tracks = new ArrayList<>();
        Tracks.add("Circuit de Spa-Francorchamps");
        Tracks.add("Silverstone Circuit");
        Tracks.add("Laguna Seca Raceway");

        myRecyclerView = findViewById(R.id.recycler_view);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new MainAdapter(MountainsA);
        myRecyclerView.setAdapter(myAdapter);

    }
}


