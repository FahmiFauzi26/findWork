package com.example.findwork.perusahaan.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findwork.R;

import java.util.ArrayList;

public class LowonganAdapter extends RecyclerView.Adapter<LowonganAdapter.LowonganViewHolder> {

    private ArrayList<Lowongan> listLowongan;

    public LowonganAdapter(ArrayList<Lowongan> listLowongan) {
        this.listLowongan = listLowongan;
    }

    @NonNull
    @Override
    public LowonganAdapter.LowonganViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_lowongan_kerja, parent, false);
        return new LowonganViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LowonganAdapter.LowonganViewHolder holder, int position) {
        holder.tvPosisiLowongan.setText(listLowongan.get(position).getPosisiLowongan());
        holder.tvNamaPerusahaan.setText(listLowongan.get(position).getNamaPerusahaan());
        holder.tvAlamatLowongan.setText(listLowongan.get(position).getAlamatLowongan());
        holder.tvMinimalPendidikan.setText(listLowongan.get(position).getMinimalPendidikan());
        holder.tvGaji.setText(listLowongan.get(position).getGaji());
        holder.tvTenggatLowongan.setText(listLowongan.get(position).getTenggatLowongan());
    }

    @Override
    public int getItemCount() {
        return (listLowongan != null) ? listLowongan.size() : 0;
    }

    public class LowonganViewHolder extends RecyclerView.ViewHolder{

        private TextView tvPosisiLowongan, tvNamaPerusahaan, tvAlamatLowongan, tvMinimalPendidikan, tvGaji, tvTenggatLowongan;

        public LowonganViewHolder (View view) {
            super(view);

            tvPosisiLowongan = view.findViewById(R.id.posisiLowonganView);
            tvNamaPerusahaan = view.findViewById(R.id.namaPerusahaanView);
            tvAlamatLowongan = view.findViewById(R.id.alamatLowonganView);
            tvMinimalPendidikan = view.findViewById(R.id.minimalPendidikanView);
            tvGaji = view.findViewById(R.id.gajiView);
            tvTenggatLowongan = view.findViewById(R.id.tenggatLowonganView);
        }
    }
}
