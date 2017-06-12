package com.example.almig.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almig.android.model.CulturalAssetDescriptionModel;
import com.example.almig.android.util.DummyCulturalAssetDescriptionContent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CulturalAssetDescriptionActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ImageView mMainImage;
    private ImageView mSubImage;
    private TextView mName;
    private TextView mAge;
    private TextView mAddr;
    private TextView mOpenTime;
    private TextView mCloseTime;
    private TextView mEntranceFee;
    private TextView mParkingFee;
    private TextView mDescription;
    private GoogleMap mMap;
    private LatLng loc;

    private void initBinding() {
        mMainImage = (ImageView)findViewById(R.id.iv_cultural_asset_description_main_image);
        mSubImage = (ImageView) findViewById(R.id.iv_cultural_asset_description_upper_sub_image);
        mName = (TextView)findViewById(R.id.rtv_cultural_asset_description_name);
        mAge = (TextView)findViewById(R.id.rtv_cultural_asset_description_age);
        mAddr = (TextView)findViewById(R.id.rtv_cultural_asset_description_addr);
        mOpenTime = (TextView)findViewById(R.id.rtv_cultural_asset_description_opentime);
        mCloseTime = (TextView)findViewById(R.id.rtv_cultural_asset_description_closetime);
        mEntranceFee = (TextView)findViewById(R.id.rtv_cultural_asset_description_entrance_fee);
        mParkingFee = (TextView)findViewById(R.id.rtv_cultural_asset_description_parking_fee);
        mDescription = (TextView)findViewById(R.id.rtv_cultural_asset_description_summary);
    }

    private void initUI(String name) {
        CulturalAssetDescriptionModel model = null;

        if(name.equals(getString(R.string.gyeongju_cultural_asset_name_chumsungdae))) {
            model = DummyCulturalAssetDescriptionContent.getGyeongJuCulturalAssetDescriptionModels().get(0);
            loc = new LatLng(35.834987, 129.219063);
        }
        else if(name.equals(getString(R.string.gyeongju_cultural_asset_name_bunhwangsa))) {
            model = DummyCulturalAssetDescriptionContent.getGyeongJuCulturalAssetDescriptionModels().get(1);
            loc = new LatLng(35.840586, 129.233702);
        }

        mMainImage.setImageResource(model.getMainImage());
        mSubImage.setImageResource(model.getUpperSubImage());
        mName.setText(model.getName());
        mAge.setText(model.getAge());
        mAddr.setText(model.getAddr());
        mOpenTime.setText("오픈시간 " + model.getOpenTime());
        mCloseTime.setText("종료시간 " + model.getCloseTime());
        mEntranceFee.setText("입장료 : " + String.valueOf(model.getEntranceFee()) + "원");
        mParkingFee.setText("주차료 : " + String.valueOf(model.getParkingFee()) + "원");
        mDescription.setText(model.getDescription());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural_asset_description);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.gmap_cultural_asset_description_lower_sub_map);
        mapFragment.getMapAsync(this);

        initBinding();
        initUI(getIntent().getExtras().getString("name"));
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

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(loc).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 18));
    }
}
