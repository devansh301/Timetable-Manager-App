package com.example.timemanagerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    Button LoginBtn;
    EditText user_edit_text, password_edit_text;
    TextView forgotpasswordbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotpasswordbutton = findViewById(R.id.textView8);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Please Wait");

        user_edit_text = findViewById(R.id.editTextTextEmailAddress);
        password_edit_text = findViewById(R.id.editTextTextPassword);
        LoginBtn = findViewById(R.id.button);
        forgotpasswordbutton = findViewById(R.id.textView8);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        forgotpasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgotPasswordFunc();
            }
        });

        if(mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void SignUpFunc(View view){
        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }
    public void ForgotPasswordFunc(){
        Intent intent = new Intent(this, ForgotPasswordActivity2.class);
        startActivity(intent);
    }
    public  void login(){
        String email = user_edit_text.getText().toString().trim();
        String password = password_edit_text.getText().toString().trim();

        if((!email.isEmpty())&&(!password.isEmpty())){
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful()){
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else{
            Toast.makeText(this, "Enter Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}

