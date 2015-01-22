package com.example.clayfaith.whereonearth;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements LocationListener {

    //Location manager
    LocationManager location_manager;
    TextView location_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init: location manager
        location_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location;
        String provider;
        location_text_view = (TextView) findViewById(R.id.textView);

        //Get the initial location
        provider = location_manager.getBestProvider(new Criteria(), false);
        location = location_manager.getLastKnownLocation(provider);
        Log.d("location", new Double(location.getLatitude()).toString());
        Log.d("location", new Double(location.getLongitude()).toString());
        printLocation(location);

        //Provider check
        if(location_manager.isProviderEnabled(provider)) {
            Log.d("location", "Provider is enabled");
        } else {
            Log.d("location", "Provider is not enabled");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("location", new Double(location.getLatitude()).toString());
        Log.d("location", new Double(location.getLongitude()).toString());
        printLocation(location);
    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    public void printLocation(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        sb.append(", ");
        sb.append(location.getLongitude());
        location_text_view.setText(sb.toString());
    }
}
