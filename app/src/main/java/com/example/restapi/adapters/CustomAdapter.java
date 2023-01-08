package com.example.restapi.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi.R;
import com.example.restapi.models.State;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<State> dataset;

    public CustomAdapter(ArrayList<State> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewNative = holder.textViewNative;
        ImageView imageViewFlag = holder.imageViewFlag;

        textViewName.setText(dataset.get(position).getName());
        textViewNative.setText(dataset.get(position).getNativeName());
        imageViewFlag.setImageBitmap(dataset.get(position).getFlag());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewNative;
        ImageView imageViewFlag;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNative = itemView.findViewById(R.id.textViewNativeName);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }
    }
}