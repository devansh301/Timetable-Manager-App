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
//////////////////////////////////////////
//      ___  ___       ___    __   _    //             //Activity gets terminated on clicking getlink after writing a valid email address
//     /   |/   |     /   |  |  \ | |   //
//    / /|   /| |    / /| |  |   \| |   //
//   / / |__/ | |   / /_| |  | |\   |   //
//  / /       | |  / /  | |  | | \  |   //
// /_/        |_| /_/   |_|  |_|  \_|   //
//                                      //
//////////////////////////////////////////

public class ForgotPasswordActivity2 extends AppCompatActivity {

    EditText editText_email;
    Button button;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);

        editText_email = findViewById(R.id.editTextTextEmailAddress2);
        button = findViewById(R.id.button4);

//        getSupportActionBar().hide();
        progressDialog = new ProgressDialog(ForgotPasswordActivity2.this);
        progressDialog.setTitle("Sending Link");
        progressDialog.setMessage("Please Wait ........");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText_email.getText().toString().trim();
                progressDialog.show();
                if(email.isEmpty()){
                    progressDialog.dismiss();
                    Toast.makeText(ForgotPasswordActivity2.this, "Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else{
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    progressDialog.dismiss();
                    Toast.makeText(ForgotPasswordActivity2.this, "Enter a valid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    auth.sendPasswordResetEmail(email)        //PLEASE CHECK THIS: IT IS SHOWING THE INPUT STRING IS NULL
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ForgotPasswordActivity2.this, "Reset Like is Sent", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ForgotPasswordActivity2.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                }
            }
        });
    }
}