package cs258.emerapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Z370 on 11/4/2015.
 */
public class LocationMap extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
     GoogleMap map;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_maps);
          SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                  .findFragmentById(R.id.map);
          mapFragment.getMapAsync(this);
     }

     @Override
     public void onMapReady(GoogleMap map) {
          //retrieve lat and lang values of the locations and put markers
          LatLng sydney = new LatLng(-34, 151);
          map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
          map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
     }

     @Override
     public void onMapLongClick(LatLng point) {

          //    mMap.animateCamera(CameraUpdateFactory.newLatLng(point));

          map.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 20));

          // Zoom in, animating the camera.
          // mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
          Toast.makeText(getApplicationContext(), point.toString(),
                  Toast.LENGTH_LONG).show();
     }

     @Override
     public void onMapClick(LatLng latLng) {
          Toast.makeText(getApplicationContext(),latLng.toString(),
                  Toast.LENGTH_LONG).show();
     }


}
