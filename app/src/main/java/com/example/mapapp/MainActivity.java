package com.example.mapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Initialize Map
    EditText etSource,etDestination;
    Button btTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack =  findViewById(R.id.bt_track);

       btTrack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Get Value from edit Text
               String sSource = etSource.getText().toString().trim();
               String sDestination = "ISPARK Caddebostan Migros Otoparkı";

               //Check condition
               if(sSource.equals("") ){
                   //When both values empty

                   Toast.makeText(getApplicationContext(), "Geben Sie Ihre Standort", Toast.LENGTH_SHORT).show();
               }else{
                   //Display track
                   DisplayTrack(sSource, sDestination);
               }
                   
           }
       });
    }

    private void DisplayTrack(String sSource, String sDestination) {
        //redirect to GooglePlay
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"
                    + sDestination);
            //Initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            //When google map is not installed
            //Initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //Initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);

        }
    }
}