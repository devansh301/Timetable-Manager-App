package com.example.timemanagerapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanagerapplication.Models.postpondedTaskmodel;
import com.example.timemanagerapplication.R;

import java.util.ArrayList;

public class postpondedTaskAdapter extends RecyclerView.Adapter<postpondedTaskAdapter.myviewholder2> {

    public postpondedTaskAdapter(ArrayList<postpondedTaskmodel> dataholder2) {
        this.dataholder2 = dataholder2;
    }

    ArrayList<postpondedTaskmodel> dataholder2;

    @NonNull
    @Override
    public myviewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout_file,parent,false);
        return new myviewholder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder2 holder, int position) {
        holder.header.setText(dataholder2.get(position).getHeader());
        holder.desc.setText(dataholder2.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataholder2.size();
    }

    class myviewholder2 extends RecyclerView.ViewHolder{
        TextView header,desc;
        public myviewholder2(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.t1);
            desc = itemView.findViewById(R.id.t2);
        }
    }

}
