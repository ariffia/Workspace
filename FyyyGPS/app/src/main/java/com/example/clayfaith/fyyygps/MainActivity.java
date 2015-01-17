package com.example.clayfaith.fyyygps;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements LocationListener {

    //Location
    private LocationManager location_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Location

        //Location manager init
        Log.d("location","Test???");
        location_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //First location print
        Criteria criteria = new Criteria();
        String provider = location_manager.getBestProvider(criteria, false);
        Location location = location_manager.getLastKnownLocation(provider);
        double altitude = location.getAltitude();
        double longitude = location.getLongitude();
        Log.d("location", new Double(altitude).toString());
        Log.d("location", new Double(longitude).toString());
    }

    @Override
    public void onLocationChanged(Location location) {
        double altitude = location.getAltitude();
        double longitude = location.getLongitude();
        Log.d("location", new Double(altitude).toString());
        Log.d("location", new Double(longitude).toString());
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("location","Provider is enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("location","Provider is disabled");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}