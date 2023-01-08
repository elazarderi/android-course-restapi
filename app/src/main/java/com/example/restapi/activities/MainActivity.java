package com.example.restapiapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.restapi.R;
import com.example.restapi.adapters.CustomAdapter;
import com.example.restapi.models.State;
import com.example.restapi.services.DataServices;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataServices ds = new DataServices();
        ArrayList<State> arr = ds.getArrState();

        CustomAdapter ca = new CustomAdapter(arr);
        RecyclerView recyclerView = (RecyclerView)  findViewById(R.id.my_recycler_view);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ca);
    }
}