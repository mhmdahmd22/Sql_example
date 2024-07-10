package com.example.sqlexample;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<HashMap<String, String>> data;
    Activity activity;

    public MyAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.data = data;
        this.activity = activity;
    }

    // This method is used to attach
    // custom layout to the recycler view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater LI = activity.getLayoutInflater();
        View vw = LI.inflate(R.layout.recycler_layout, null);
        return new ViewHolder(vw);
    }

    // This method is used to set the action
    // to the widgets of our custom layout.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String date = data.get(position).get("date");
        String time = data.get(position).get("time");
        String amount = data.get(position).get("amount");
        String pan = data.get(position).get("pan");
        String api = data.get(position).get("api");

        holder.date.setText(date);
        holder.time.setText(time);
        holder.amount.setText(amount);
        holder.pan.setText(pan);
        holder.api.setText(api);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, time, amount, pan, api;

        public ViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            amount = itemView.findViewById(R.id.amount);
            pan = itemView.findViewById(R.id.pan);
            api = itemView.findViewById(R.id.api);
        }
    }
}

