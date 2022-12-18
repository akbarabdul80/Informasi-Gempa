package com.zero.informasigempa.ui.maps;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zero.informasigempa.R;
import com.zero.informasigempa.databinding.ActivityMapsBinding;
import com.zero.informasigempa.response.current.Gempa;
import com.zero.informasigempa.response.history.GempaItem;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityMapsBinding binding;
    private GoogleMap mMap;

    private GempaItem gempaItem;
    private Gempa gempa;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gempaItem = (GempaItem) getIntent().getSerializableExtra("gempaItem");
        gempa = (Gempa) getIntent().getSerializableExtra("gempa");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.btnBack.setOnClickListener(v -> finish());

        if (gempaItem != null) {
            String textJamTanggal = gempaItem.getJam() + " - " + gempaItem.getTanggal();
            String textMagnitude = gempaItem.getMagnitude() + " SR";
            String textDirasakan = "( " + gempaItem.getDirasakan() + " )";
            String textLintangBujur = gempaItem.getLintang() + " " + gempaItem.getBujur();

            binding.tvMagnitude.setText(textMagnitude);
            binding.tvJamTanggal.setText(textJamTanggal);
            binding.tvWilayah.setText(gempaItem.getWilayah());
            binding.tvKedalaman.setText(gempaItem.getKedalaman());
            binding.tvDirasakan.setText(textDirasakan);
            binding.tvLintangBujur.setText(textLintangBujur);
            latLng = new LatLng(Double.parseDouble(gempaItem.getCoordinates().split(",")[0]), Double.parseDouble(gempaItem.getCoordinates().split(",")[1]));
        } else if (gempa != null) {
            String textJamTanggal = gempa.getJam() + " - " + gempa.getTanggal();
            String textMagnitude = gempa.getMagnitude() + " SR";
            String textDirasakan = "( " + gempa.getDirasakan() + " )";
            String textLintangBujur = gempa.getLintang() + " " + gempa.getBujur();

            binding.tvMagnitude.setText(textMagnitude);
            binding.tvJamTanggal.setText(textJamTanggal);
            binding.tvWilayah.setText(gempa.getWilayah());
            binding.tvKedalaman.setText(gempa.getKedalaman());
            binding.tvDirasakan.setText(textDirasakan);
            binding.tvLintangBujur.setText(textLintangBujur);
            latLng = new LatLng(Double.parseDouble(gempa.getCoordinates().split(",")[0]), Double.parseDouble(gempa.getCoordinates().split(",")[1]));
        }

    }

    private void moveCamera(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 6f));

    }

    private void addMarker(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        moveCamera(latLng);
        addMarker(latLng);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}