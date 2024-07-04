package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.DetailActivity;
import com.example.myapplication.FillDetail;
import com.example.myapplication.R;
import com.example.myapplication.model.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {
    ArrayList<Room> rooms;

    public RoomAdapter(ArrayList<Room> room) {
        this.rooms =room;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_room, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(rooms.get(position).getTitle());
        int drawableID = holder.itemView.getContext().getResources().getIdentifier(
                rooms.get(position).getImg(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(holder.itemView.getContext())
                .load(drawableID)
                .into(holder.img);


        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("object", rooms.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return rooms.size();
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
