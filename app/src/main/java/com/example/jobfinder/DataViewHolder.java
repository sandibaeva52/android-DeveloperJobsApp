package com.example.jobfinder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {
TextView title, type, createdAt;
ImageView logo;
    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title);
        type=itemView.findViewById(R.id.type);
        createdAt=itemView.findViewById(R.id.createdAt);
        logo=itemView.findViewById(R.id.logo);
    }
}
