package com.gilbut.mapgyeongju;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private int MY_LOCATION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                                PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                }
                mMap.setMyLocationEnabled(true);
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        LatLng tour = new LatLng(35.790228, 129.332082);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("불국사")
                .snippet("통일 신라 시대에 김대성의 발원으로 창건한 사찰")
        );

        tour = new LatLng(35.829349, 129.2158143);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("월정교")
                .snippet("원효대사는 월정교를 건너 요석궁에 들어갔다는 기록에 따라 복원한 통일 신라 시대 다리")
        );

        tour = new LatLng(35.835083, 129.2184388);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("첨성대")
                .snippet("신라 시대 선덕여왕 때 건립된 천문대, 국보 제31호")
        );

        tour = new LatLng(35.8378847, 129.2320256);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("황룡사지")
                .snippet("진흥왕 때 세운 신라 시대 가장 큰 사찰이었으나 몽골의 침입으로 불타고 현재는 터만 남음")
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(tour));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tour,16));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tour,20));

        tour = new LatLng(35.795123, 129.349690);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("석굴암")
                .snippet("통일 신라 시대에 김대성이 창건한 사찰")
        );

        tour = new LatLng(35.834468, 129.226635);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("안압지")
                .snippet("통일 신라 시대에 축조된 연못")
        );

        tour = new LatLng(35.838732, 129.210383);
        mMap.addMarker(new MarkerOptions()
                .position(tour)
                .title("천마총")
                .snippet("신라 시대 만든 돌무지덧널무덤")
        );


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getTitle().equals("불국사")) {
                    String url = "http://www.bulguksa.or.kr";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                if (marker.getTitle().equals("석굴암")) {
                    String url = "http://seokguram.org";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }
}
