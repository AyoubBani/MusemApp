package com.example.museumapp;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.app.Fragment;
public class CarteFragment extends Fragment {
MapView mMapView;
private GoogleMap googleMap;
public CarteFragment(){}
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // inflat and return the layout
    View v = inflater.inflate(R.layout.maps, container,
            false);
    mMapView = (MapView) v.findViewById(R.id.mapView);
    mMapView.onCreate(savedInstanceState);

    mMapView.onResume();// needed to get the map to display immediately

    try {
        MapsInitializer.initialize(getActivity().getApplicationContext());
    } catch (Exception e) {
        e.printStackTrace();
    }

    googleMap = mMapView.getMap();
    // latitude and longitude
    double latitude =  34.0151436	;
    double longitude = -6.832916699999942;

    // create marker
    MarkerOptions marker = new MarkerOptions().position(
            new LatLng(latitude, longitude)).title("bienvenuue dans le musee de casablanca");

    // Changing marker icon
    marker.icon(BitmapDescriptorFactory
            .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

    // adding marker
    googleMap.addMarker(marker);
    CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(new LatLng(34.0151436 , -6.832916699999942)).zoom(20).build();
    googleMap.animateCamera(CameraUpdateFactory
            .newCameraPosition(cameraPosition));

    // Perform any camera updates here
    return v;
}

@Override
public void onResume() {
    super.onResume();
    mMapView.onResume();
}

@Override
public void onPause() {
    super.onPause();
    mMapView.onPause();
}

@Override
public void onDestroy() {
    super.onDestroy();
    mMapView.onDestroy();
}

@Override
public void onLowMemory() {
    super.onLowMemory();
    mMapView.onLowMemory();
}
}