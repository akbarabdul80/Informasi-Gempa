package com.zero.informasigempa.ui.current;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.zero.informasigempa.databinding.FragmentCurrentEarthquakeBinding;
import com.zero.informasigempa.network.ApiConfig;
import com.zero.informasigempa.ui.maps.MapsActivity;

public class CurrentEarthquakeFragment extends Fragment {
    private CurrentEarthquakeViewModel viewModel;
    private FragmentCurrentEarthquakeBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new CurrentEarthquakeViewModel();
        viewModel.findCurrentEarthquake();

        initObserver();
    }

    void initObserver() {
        viewModel.getGempaMutableLiveData().observe(getViewLifecycleOwner(), it -> {
            String textJamTanggal = it.getJam() + " - " + it.getTanggal();
            String textMagnitude = it.getMagnitude() + " SR";
            String textDirasakan = "( " + it.getDirasakan() + " )";
            String textLintangBujur = it.getLintang() + " " + it.getBujur();

            binding.tvMagnitude.setText(textMagnitude);
            binding.tvJamTanggal.setText(textJamTanggal);
            binding.tvWilayah.setText(it.getWilayah());
            binding.tvKedalaman.setText(it.getKedalaman());
            binding.tvDirasakan.setText(textDirasakan);
            binding.tvLintangBujur.setText(textLintangBujur);
            binding.tvPotensi.setText(it.getPotensi());

            Glide.with(requireContext())
                    .load(ApiConfig.BASE_URL + it.getShakemap())
                    .into(binding.ivMap);

            binding.btnLihatLokasi.setOnClickListener(
                    view -> {
                        Intent intent = new Intent(requireContext(), MapsActivity.class);
                        intent.putExtra("gempa", it);
                        startActivity(intent);
                    }
            );
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCurrentEarthquakeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}