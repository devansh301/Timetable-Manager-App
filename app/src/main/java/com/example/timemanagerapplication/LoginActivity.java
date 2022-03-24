package com.example.timemanagerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.filament.View;

public class LoginActivity extends AppCompatActivity {

    private TextView SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignUp = (TextView) findViewById(R.id.SignUp);
        SignUp.setOnClickListener((android.view.View.OnClickListener) this);
    }
//    @Override
//    public

}