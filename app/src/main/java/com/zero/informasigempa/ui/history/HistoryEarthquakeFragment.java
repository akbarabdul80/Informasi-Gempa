package com.zero.informasigempa.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zero.informasigempa.databinding.FragmentHistoryEarthquakeBinding;

public class HistoryEarthquakeFragment extends Fragment {

    private FragmentHistoryEarthquakeBinding binding;
    private HistoryEarthquakeViewModel viewModel;
    private HistoryEarthquakeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryEarthquakeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new HistoryEarthquakeViewModel();
        binding.rvHistory.setLayoutManager(new LinearLayoutManager(requireContext()));
        initListener();
    }

    private void initListener() {
        viewModel.findGempaInfo();
        viewModel.observeHistoryGempa().observe(getViewLifecycleOwner(), it -> {
            adapter = new HistoryEarthquakeAdapter(it);
            binding.rvHistory.setAdapter(adapter);
        });
    }
}