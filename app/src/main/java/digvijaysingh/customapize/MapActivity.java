package digvijaysingh.customapize;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = MapActivity.class.getSimpleName();
    private String[] mapStyle = {
            "Starry Night",
            "Ancient westeros",
            "Dark knight's favourite",
            "Tony stark's World",
            "Colorless beauty",
            "Old muddy denim"};
    private int style_id=R.raw.style_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeTheme(getIntent().getIntExtra("position",0));
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_map);

        // Get the SupportMapFragment and register for the callback
        // when the map is ready for use.
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void changeTheme(int position) {

        setTitle(mapStyle[position]);
        switch (position)
        {
            case 0: setTheme(R.style.themeone);
                style_id=R.raw.style_json;
                break;
            case 1: setTheme(R.style.themetwo);
                style_id=R.raw.style_json_orangewater;
                break;
            case 2: setTheme(R.style.themeThree);
                style_id=R.raw.style_json_dark_night;
                break;
            case 3: setTheme(R.style.themeFour);
                style_id=R.raw.style_json_iron_man;
                break;
            case 4: setTheme(R.style.themeFive);
                style_id=R.raw.style_json_black_white;
                break;
            case 5: setTheme(R.style.themeSix);
                style_id=R.raw.style_json_blue_yellow;
                break;
        }
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready for use.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {

        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, style_id));


            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }


        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-34, 151)));

        LatLng coordinate = new LatLng(20.5937, 78.9629);
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(coordinate, 3);
        googleMap.animateCamera(location);


    }
}
