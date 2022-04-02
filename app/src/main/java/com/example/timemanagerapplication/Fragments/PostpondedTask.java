package com.example.timemanagerapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timemanagerapplication.Adapters.TasksAdapter;
import com.example.timemanagerapplication.Adapters.postpondedTaskAdapter;
import com.example.timemanagerapplication.Models.postpondedTaskmodel;
import com.example.timemanagerapplication.Models.taskmodel;
import com.example.timemanagerapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostpondedTask#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostpondedTask extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<postpondedTaskmodel> dataholder2;

    public PostpondedTask() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostpondedTask.
     */
    // TODO: Rename and change types and number of parameters
    public static PostpondedTask newInstance(String param1, String param2) {
        PostpondedTask fragment = new PostpondedTask();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        View view = inflater.inflate(R.layout.fragment_postponded_task, container, false);
        recyclerView = view.findViewById(R.id.rclview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder2 = new ArrayList<postpondedTaskmodel>();

        postpondedTaskmodel ob1=new postpondedTaskmodel(/*R.drawable.angular, */"Task1", "Task Description");
        dataholder2.add(ob1);
        postpondedTaskmodel ob2=new postpondedTaskmodel(/*R.drawable.cp,*/ "Task2", "Task Description");
        dataholder2.add(ob2);
        postpondedTaskmodel ob3=new postpondedTaskmodel(/*R.drawable.cpp,*/ "Task3", "Task Description");
        dataholder2.add(ob3);
        postpondedTaskmodel ob4=new postpondedTaskmodel(/*R.drawable.dotnet, */"Task4", "Task Description");
        dataholder2.add(ob4);
        postpondedTaskmodel ob5=new postpondedTaskmodel(/*R.drawable.angular,*/ "Task5", "Task Description");
        dataholder2.add(ob5);
        postpondedTaskmodel ob6=new postpondedTaskmodel(/*R.drawable.cp,*/ "Task6", "Task Description");
        dataholder2.add(ob6);
        postpondedTaskmodel ob7=new postpondedTaskmodel(/*R.drawable.cpp,*/ "Task7", "Task Description");
        dataholder2.add(ob7);
        postpondedTaskmodel ob8=new postpondedTaskmodel(/*R.drawable.dotnet,*/ "Task8", "Task Description");
        dataholder2.add(ob8);
        postpondedTaskmodel ob9=new postpondedTaskmodel(/*R.drawable.angular,*/ "Task9", "Task Description");
        dataholder2.add(ob9);
        postpondedTaskmodel ob10=new postpondedTaskmodel(/*R.drawable.cp,*/ "Task10", "Task Description");
        dataholder2.add(ob10);
        postpondedTaskmodel ob11=new postpondedTaskmodel(/*R.drawable.cpp,*/ "Task11", "Task Description");
        dataholder2.add(ob11);
        postpondedTaskmodel ob12=new postpondedTaskmodel(/*R.drawable.dotnet,*/ "Task12", "Task Description");
        dataholder2.add(ob12);
        
        recyclerView.setAdapter(new postpondedTaskAdapter(dataholder2));
        return view;
    }
}