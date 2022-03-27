package com.example.timemanagerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

//import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void func(View view){
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivity(intent);
    }
}