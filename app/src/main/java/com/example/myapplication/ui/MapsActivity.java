package com.example.myapplication.ui;

import static com.example.myapplication.util.Constants.PERMISSIONS_REQUEST_ENABLE_GPS;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by Meryem on 01/01/2021.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 9000;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private boolean mLocationPermissionGranted = false ;
    private FirebaseFirestore mDb ;

    public MapsActivity(boolean mLocationPermissionGranted, FirebaseFirestore mDb) {
        this.mLocationPermissionGranted = mLocationPermissionGranted;
        this.mDb = mDb;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private boolean checkMapServices(){
        if(isServicesOK()){
            if(isMapsEnabled()){
                return true;
            }
        }
        return false;
    }



    public boolean isMapsEnabled(){
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            buildAlertMessageNoGps();
            return false;
        }
        return true;
    private void buildAlertMessageNoGps;() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This application requires GPS to work properly, do you want to enable it?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                Intent enableGpsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(enableGpsIntent, PERMISSIONS_REQUEST_ENABLE_GPS);
            }
        });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    private void getLocationPermission;() boolean mLocationPermissionGranted;
        {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
    }
    @Override
    public void onMapReady(GoogleMap GoogleMap googleMap;
        googleMap) {
        mMap = googleMap;

        // Add a marker in Caddebostan and move the camera
        LatLng CaddebostanPark = new LatLng(	40.962856, 29.061369);
        mMap.addMarker(new MarkerOptions().position(CaddebostanPark).title("Marker in CaddebostanPark"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CaddebostanPark));
    }

    private static final String TAG = "MapActivity";

    private static final String FINE_LOCATION = AndroidManifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = AndroidManifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;


    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;

    public void onZoom(View Thread view;
        view){
        if(view.getId()== R.id.zoomIn)(
              mMap.animateCamera(CameraUpdateFactory.zoomIn());
                 )
        if(view.getId()== R.id.zoomout)(
                mMap.animateCamera(CameraUpdateFactory.zoomOut());

                )
    }
}

    public boolean isServicesOK() {
        return servicesOK;
    }

    private static class ContextCompat {
    }

    private class ActivityCompat {
    }