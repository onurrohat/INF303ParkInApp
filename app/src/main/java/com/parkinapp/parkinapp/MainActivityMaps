package com.example.googlemapdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    //Checking the Version
    private static final String TAG = "Main Activity";
    private static final int ERROR_DIALOG_REQUEST=9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void init(){
        Button btnMap  = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent  = new Intent(MainActivity.this , MapActivity.class);
                startActivity(intent);

            }
        });
    }
    public boolean isServicesUpdated(){
        Log.d(TAG , "isServicesUpdated:checking Google Services Version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available == ConnectionResult.SUCCESS){
            //Version of the Services is up to Date
            //Map Request can be made
            Log.d(TAG , "isServicesUpdated: Google Play Services is current");
            return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //A resolvable ERROR occured
            Log.d(TAG , "isServicesUpdated: Wrong Google Play Services Version");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this , available , ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "Map request can not be made.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
