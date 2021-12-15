package com.parkinapp.parkinapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText fullName,editTextTextPersonName2,password,password2 ;
    Button button ;
    TextView textView2,textView4,textView3 ;
    FirebaseAuth firebaseAuth ;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView3 = findViewById(R.id.textView3) ;
        fullName =  findViewById(R.id.fullName);
        editTextTextPersonName2  =  findViewById(R.id.editTextTextPersonName2);
        password =  findViewById(R.id.password);
        password2 =findViewById(R.id.password2);
        button = findViewById(R.id.button);
        textView2 =findViewById(R.id.textView2);
        textView4= findViewById(R.id.textView4);

        firebaseAuth = FirebaseAuth.getInstance() ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=editTextTextPersonName2.getText().toString().trim();
                String passwordd=password.getText().toString().trim();


                if(TextUtils.isEmpty(email)) {
                    editTextTextPersonName2.setError("Email is Required");
                    return ;

                }

                if(TextUtils.isEmpty(passwordd)) {

                    password.setError("Password is Required");

                    return;
                }

                if(passwordd.length()<6) {

                    password.setError("Password Must be >= 6 Characters");

                    return;
                }

              //  firebaseAuth.createUserWithEmailAndPassword(email,passwordd).addOnCompleteListener(new OnCompleteListener<AuthResult>()) {
                    //@Override
                    //public void onComplete(@NonNull Task<AuthResult> task) {

                       // if(task.İsSuccessful()) {

                            Toast.makeText(Register.this,"User Created" ,Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        //else{
                         //   Toast.makeText(Register.this,"Error !"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        //}





            }); } }



