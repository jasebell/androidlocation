package eu.bigdatagames;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends Activity {
    Button btnShowLocation;

    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        gps = new GPSTracker(MyActivity.this);

    }

    public void updateLocation(View view){
        // check if GPS enabled
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            StringBuilder thisString = new StringBuilder()
                    .append("Your Location is - \nLat: " + latitude + "\nLong: " + longitude)
                    .append("\nGPS enabled is " + gps.isGPSEnabled)
                    .append("\nNetwork enabled is " + gps.isNetworkEnabled);
            Toast.makeText(getApplicationContext(), thisString.toString(), Toast.LENGTH_LONG).show();
        } else {
            gps.showSettingsAlert();
        }
    }
}

