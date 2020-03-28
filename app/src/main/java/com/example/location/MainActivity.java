package com.example.location;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    protected LocationManager locationManager;
    TextView txtlat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtlat = (TextView) findViewById(R.id.textView1);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }


        locationManager.requestLocationUpdates
                (locationManager.GPS_PROVIDER,0,0,this);





    }

    @Override
    public void onLocationChanged(Location location) {



        txtlat.setText("Latitude : "+location.getLatitude() + "Longitude : "+location.getLongitude());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
