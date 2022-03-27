package com.example.timemanagerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ForgotPasswordActivity2 extends AppCompatActivity {

    EditText editText_email;
    Button button;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);

        editText_email = findViewById(R.id.editTextTextEmailAddress2);
        button = findViewById(R.id.button4);

        progressDialog = new ProgressDialog(ForgotPasswordActivity2.this);
        progressDialog.setTitle("Sending Link");
        progressDialog.setMessage("Please Wait ........");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText_email.getText().toString().trim();
                progressDialog.show();
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressDialog.dismiss();
                                    if(task.isSuccessful()){
                                        Toast.makeText(ForgotPasswordActivity2.this, "Reset Like is Sent", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(ForgotPasswordActivity2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}