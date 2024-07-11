package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.DetailActivity;
import com.example.myapplication.Entities.Event;
import com.example.myapplication.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder>{
    ArrayList<Event> events;
    public EventAdapter(ArrayList<Event> events) {
        this.events =events;
    }
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_event, parent, false);
        return new RoomAdapter.ViewHolder(inflate);
    }
    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(events.get(position).getTitle());
        int drawableID = holder.itemView.getContext().getResources().getIdentifier(
                events.get(position).getImg(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(holder.itemView.getContext())
                .load(drawableID)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle;
        TextView txtDescription;
        ConstraintLayout mainLayout;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.namehotel_tophotel);
            img = itemView.findViewById(R.id.img_room);
            mainLayout = itemView.findViewById(R.id.room_layout);
        }
    }
}