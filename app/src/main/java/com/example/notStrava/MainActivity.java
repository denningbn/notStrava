package com.example.notStrava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    public static final int DEFAULT_UPDATE_INTERVAL = 30;
    public static final int FAST_UPDATE_INTERVAL = 5;

    TextView tv_lat, tv_lon, tv_altitude, tv_accuracy, tv_speed, tv_sensor, tv_updates, tv_address;

    Switch sw_locationupdates, sw_gps;

    FusedLocationProviderClient fusedLocationProviderClient;

    LocationRequest locationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_lat = findViewById(R.id.tv_lat);
        tv_lon = findViewById(R.id.tv_lon);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_speed = findViewById(R.id.tv_speed);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);

        sw_gps = findViewById(R.id.sw_gps);
        sw_locationupdates = findViewById(R.id.sw_locationsupdates);

        //set properties of locationRequest


        locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, DEFAULT_UPDATE_INTERVAL * 1000).build();

        //TODO:
        // Set fastest interval time for locationrequest
        // locationRequest = new LocationRequest.Builder(locationRequest).set

        sw_gps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (sw_gps.isChecked()) {
                    //TODO
                    //set priority to high accuracy

                    tv_sensor.setText("Using GPS Sensors");
                } else {
                    //TODO:
                    //set priority to balanced

                    tv_sensor.setText("Using Towers and WIFI");
                }
            }
        });

        sw_locationupdates.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (sw_locationupdates.isChecked()) {
                    //TODO
                    //set priority to high accuracy

                    tv_updates.setText("Recurring");
                } else {
                    //TODO:
                    //set priority to balanced

                    tv_updates.setText("Off");
                }
            }
        });

        updateGPS();
    }

    private void updateGPS() {
        //get permission
        //get current location
        //update ui

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {


                tv_lat.setText(String.valueOf(location.getLatitude()));
                tv_lon.setText(String.valueOf(location.getLongitude()));

            }
        });
    }
}