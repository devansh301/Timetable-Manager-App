package com.example.timemanagerapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timemanagerapplication.Adapters.TasksAdapter;
import com.example.timemanagerapplication.Models.taskmodel;
import com.example.timemanagerapplication.R;

import java.util.ArrayList;

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

        taskmodel ob1=new taskmodel(R.drawable.angular, "Angular", "Web Application");
        dataholder.add(ob1);
        taskmodel ob2=new taskmodel(R.drawable.cp, "C Programming", "Embed Programming");
        dataholder.add(ob2);
        taskmodel ob3=new taskmodel(R.drawable.cpp, "C++ Programming", "Embed Programming");
        dataholder.add(ob3);
        taskmodel ob4=new taskmodel(R.drawable.dotnet, ".NET Programming", "Desktop and Web Programming");
        dataholder.add(ob4);
        taskmodel ob5=new taskmodel(R.drawable.angular, "Angular", "Web Application");
        dataholder.add(ob5);
        taskmodel ob6=new taskmodel(R.drawable.cp, "C Programming", "Embed Programming");
        dataholder.add(ob6);
        taskmodel ob7=new taskmodel(R.drawable.cpp, "C++ Programming", "Embed Programming");
        dataholder.add(ob7);
        taskmodel ob8=new taskmodel(R.drawable.dotnet, ".NET Programming", "Desktop and Web Programming");
        dataholder.add(ob8);
        taskmodel ob9=new taskmodel(R.drawable.angular, "Angular", "Web Application");
        dataholder.add(ob9);
        taskmodel ob10=new taskmodel(R.drawable.cp, "C Programming", "Embed Programming");
        dataholder.add(ob10);
        taskmodel ob11=new taskmodel(R.drawable.cpp, "C++ Programming", "Embed Programming");
        dataholder.add(ob11);
        taskmodel ob12=new taskmodel(R.drawable.dotnet, ".NET Programming", "Desktop and Web Programming");
        dataholder.add(ob12);

        recyclerView.setAdapter(new TasksAdapter(dataholder));
        return view;
    }
}