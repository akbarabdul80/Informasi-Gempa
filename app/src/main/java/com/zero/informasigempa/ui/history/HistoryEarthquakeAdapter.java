package com.zero.informasigempa.ui.history;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero.informasigempa.databinding.ItemHistoryEarthquakeBinding;
import com.zero.informasigempa.response.history.GempaItem;
import com.zero.informasigempa.ui.maps.MapsActivity;

import java.util.List;

public class HistoryEarthquakeAdapter extends RecyclerView.Adapter<HistoryEarthquakeAdapter.HistoryViewHolder> {
    private List<GempaItem> gempaItemList;

    public HistoryEarthquakeAdapter(List<GempaItem> gempaItems) {
        this.gempaItemList = gempaItems;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHistoryEarthquakeBinding binding = ItemHistoryEarthquakeBinding.inflate(inflater, parent, false);
        return new HistoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        GempaItem item = gempaItemList.get(position);

        String textJamTanggal = item.getJam() + " - " + item.getTanggal();
        String textMagnitude = item.getMagnitude() + " SR";
        String textDirasakan = "( " + item.getDirasakan() + " )";
        String textLintangBujur = item.getLintang() + " " + item.getBujur();

        holder.binding.tvMagnitude.setText(textMagnitude);
        holder.binding.tvJamTanggal.setText(textJamTanggal);
        holder.binding.tvWilayah.setText(item.getWilayah());
        holder.binding.tvKedalaman.setText(item.getKedalaman());
        holder.binding.tvDirasakan.setText(textDirasakan);
        holder.binding.tvLintangBujur.setText(textLintangBujur);

        holder.binding.btnLihatLokasi.setOnClickListener(v -> {
            Intent intent = new Intent(holder.binding.getRoot().getContext(), MapsActivity.class);
            intent.putExtra("gempaItem", item);
            holder.binding.getRoot().getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return gempaItemList.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        ItemHistoryEarthquakeBinding binding;

        HistoryViewHolder(ItemHistoryEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
