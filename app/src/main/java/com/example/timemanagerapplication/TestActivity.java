package com.example.timemanagerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.example.timemanagerapplication.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.file.attribute.UserPrincipalLookupService;

public class TestActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    public Button button2;
    public EditText name;public EditText Email;public EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(TestActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        name = findViewById(R.id.editTextTextPersonName5);
        Email =  findViewById(R.id.editTextTextEmailAddress3);
        Password = findViewById(R.id.editTextTextPassword3);
        button2 = findViewById(R.id.button2);

        Intent intent = getIntent();
//        getSupportActionBar().hide();

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meth();
            }
        });
    }
    public void meth(){
        String email = Email.getText().toString().trim();
        String username = name.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (username.isEmpty()){
            name.setError("User Name is required");
            name.requestFocus();
            return;
        }
        if(email.isEmpty()){
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Enter vaild Email address");
            Email.requestFocus();
            return;
        }
        if(password.isEmpty()){
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }
        if(password.length() < 6){
            Password.setError("Password is too short");
            Password.requestFocus();
            return;
        }

        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            User user = new User(username, email, password);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(TestActivity.this, "SignUp is successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(TestActivity.this, "SignUp is failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}