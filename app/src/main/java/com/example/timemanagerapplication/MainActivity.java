package com.example.timemanagerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.timemanagerapplication.Adapters.FragmentsAdapter;
import com.example.timemanagerapplication.Adapters.TasksAdapter;
import com.example.timemanagerapplication.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.zip.Inflater;

//import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //RecyclerView taskList = (RecyclerView) findViewById(R.id.taskList);
//        taskList.setLayoutManager(new LinearLayoutManager(this));
//        String[] tasks = {"Task1","Task1","Task1","Task1","Task1","Task1","Task1","Task1","Task1","Task1","Task1"};
//        taskList.setAdapter(new TasksAdapter(tasks));
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override                                             //To add menu bar on ActionBar first create menu res file and then override this method
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override                                            //To make menu items working
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.Profile:
                Intent intent1 = new Intent(this,ProfileActivity.class);
                startActivity(intent1);
                break;
            case R.id.Logout:
                mAuth.signOut();              //It will signout the activity in backend but it will remain open the mainactivity to solve this issue we write an intent
                Intent intent2 = new Intent(this,LoginActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void func(View view){
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }
}