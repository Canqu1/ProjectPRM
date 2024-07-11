package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Entities.Booking;
import com.example.myapplication.R;

import java.util.List;

public class RoomHistoryAdapter extends RecyclerView.Adapter<RoomHistoryAdapter.ViewHolder> {
    List<Booking> bookings;

    public RoomHistoryAdapter(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_doing, parent, false);
        return new ViewHolder(inflate);
    }
    @SuppressLint("DiscouragedApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(bookings.get(position).getService());
        int drawableID = holder.itemView.getContext().getResources().getIdentifier(
                bookings.get(position).getBookDate(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(holder.itemView.getContext())
                .load(drawableID)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle;
        TextView txtPrice;
        TextView txtDescription;
        TextView txtAddress;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id._162);
            txtTitle = itemView.findViewById(R.id._163);
            txtPrice = itemView.findViewById(R.id._165);
            txtDescription = itemView.findViewById(R.id._166);
            txtAddress = itemView.findViewById(R.id._169);
            mainLayout = itemView.findViewById(R.id.adapterLayout_roomHistory);
        }
    }
}
