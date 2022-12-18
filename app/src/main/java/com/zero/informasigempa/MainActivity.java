package com.zero.informasigempa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.zero.informasigempa.databinding.ActivityMainBinding;
import com.zero.informasigempa.ui.current.CurrentEarthquakeFragment;
import com.zero.informasigempa.ui.history.HistoryEarthquakeFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        openFragment(new CurrentEarthquakeFragment(), "CurrentEarthquakeFragment");

        binding.bnHome.setOnItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.currentEarthquake:
                            openFragment(new CurrentEarthquakeFragment(), "CurrentEarthquakeFragment");
                            break;
                        case R.id.historyEarthquake:
                            openFragment(new HistoryEarthquakeFragment(), "HistoryEarthquakeFragment");
                            break;
                    }
                    return true;
                }
        );
    }

    private void openFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flHome, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}