package com.example.timemanagerapplication.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanagerapplication.Models.postpondedTaskmodel;
import com.example.timemanagerapplication.Models.taskmodel;
import com.example.timemanagerapplication.R;

import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.myviewholder>{

    ArrayList<taskmodel> dataholder;

    public TasksAdapter(ArrayList<taskmodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout_file,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        //holder.img.setImageResource(dataholder.get(position).getImage());
        holder.header.setText(dataholder.get(position).getHeader());
        holder.desc.setText(dataholder.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        //ImageView img;
        TextView header,desc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            //img = itemView.findViewById(R.id.img1);
            header = itemView.findViewById(R.id.t1);
            desc = itemView.findViewById(R.id.t2);
        }
    }
}