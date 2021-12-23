
package com.parkinapp.parkinapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText fullName,password,password2 ;
    Button button ;
    TextView mEmail,textView4,textView3,textView2 ;
    FirebaseAuth firebaseAuth ;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView3 = findViewById(R.id.textView3);
        fullName = findViewById(R.id.fullName);
        textView2 = findViewById(R.id.textView2);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        button = findViewById(R.id.button);
        mEmail = findViewById(R.id.mEmail);
        textView4 = findViewById(R.id.textView4);
        progressBar = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = textView2.getText().toString().trim();
                String passwordd = password.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    textView2.setError("Email is Required");
                    return;

                }

                if (TextUtils.isEmpty(passwordd)) {

                    password.setError("Password is Required");

                    return;
                }

                if (passwordd.length() < 6) {

                    password.setError("Password Must be >= 6 Characters");

                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email, passwordd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                });
            }
        });


    }}