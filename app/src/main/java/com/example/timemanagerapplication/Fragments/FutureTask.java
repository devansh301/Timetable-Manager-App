package com.example.timemanagerapplication.Fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timemanagerapplication.Adapters.TasksAdapter;
import com.example.timemanagerapplication.Models.taskmodel;
import com.example.timemanagerapplication.R;
import com.example.timemanagerapplication.Task;
import com.example.timemanagerapplication.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FutureTask#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FutureTask extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<taskmodel> dataholder;

    private TaskViewModel mTaskViewModel;

    public FutureTask() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FutureTask.
     */
    // TODO: Rename and change types and number of parameters
    public static FutureTask newInstance(String param1, String param2) {
        FutureTask fragment = new FutureTask();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mTaskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        mTaskViewModel.getAllTasks().observe(this, new Observer<List<Task>>(){
          @Override
            public void onChanged(@NonNull final List<Task> tasks) {
              adapter.setTask(tasks);
          }
        });
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_future_task, container, false);
        recyclerView=view.findViewById(R.id.rclview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder= new ArrayList<taskmodel>();

        taskmodel ob1=new taskmodel(/*R.drawable.angular, */"Task1", "Task Description");
        dataholder.add(ob1);
        taskmodel ob2=new taskmodel(/*R.drawable.cp,*/ "Task2", "Task Description");
        dataholder.add(ob2);
        taskmodel ob3=new taskmodel(/*R.drawable.cpp,*/ "Task3", "Task Description");
        dataholder.add(ob3);
        taskmodel ob4=new taskmodel(/*R.drawable.dotnet, */"Task4", "Task Description");
        dataholder.add(ob4);
        taskmodel ob5=new taskmodel(/*R.drawable.angular,*/ "Task5", "Task Description");
        dataholder.add(ob5);
        taskmodel ob6=new taskmodel(/*R.drawable.cp,*/ "Task6", "Task Description");
        dataholder.add(ob6);
        taskmodel ob7=new taskmodel(/*R.drawable.cpp,*/ "Task7", "Task Description");
        dataholder.add(ob7);
        taskmodel ob8=new taskmodel(/*R.drawable.dotnet,*/ "Task8", "Task Description");
        dataholder.add(ob8);
        taskmodel ob9=new taskmodel(/*R.drawable.angular,*/ "Task9", "Task Description");
        dataholder.add(ob9);
        taskmodel ob10=new taskmodel(/*R.drawable.cp,*/ "Task10", "Task Description");
        dataholder.add(ob10);
        taskmodel ob11=new taskmodel(/*R.drawable.cpp,*/ "Task11", "Task Description");
        dataholder.add(ob11);
        taskmodel ob12=new taskmodel(/*R.drawable.dotnet,*/ "Task12", "Task Description");
        dataholder.add(ob12);

        recyclerView.setAdapter(new TasksAdapter(dataholder));
        return view;
    }
}