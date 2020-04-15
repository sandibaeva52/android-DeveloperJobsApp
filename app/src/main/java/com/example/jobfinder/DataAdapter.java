package com.example.jobfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Response;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
private List<DataSet> list;
private Context context;

    public DataAdapter(List<DataSet> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.row, parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
       DataSet currentdata=list.get(position);
       holder.title.setText(currentdata.getTitle());
       holder.type.setText(currentdata.getType());
       holder.createdAt.setText(currentdata.getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
