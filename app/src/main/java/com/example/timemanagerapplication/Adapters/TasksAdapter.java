package com.example.timemanagerapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanagerapplication.R;
import com.google.android.gms.tasks.Tasks;

import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder>{

    private String[] data;
    public TasksAdapter(String[] data){
        this.data = data;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sample_layout_file,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
          String title = data[position];
          holder.task_name.setText(title);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView task_name,task_description;
        public TaskViewHolder(View itemView) {
            super(itemView);
            task_name = (TextView) itemView.findViewById(R.id.TaskName);
            task_description = (TextView) itemView.findViewById(R.id.Taskdescription);
        }
    }
}