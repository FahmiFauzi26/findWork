package com.example.findwork.perusahaan.modellowongan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findwork.R;
import com.example.findwork.perusahaan.JobDetailActivity;

import java.util.ArrayList;

public class RecyclerViewAdapterLowongan extends RecyclerView.Adapter<RecyclerViewAdapterLowongan.ViewHolder> {

    private ArrayList<String> posisiLowongan = new ArrayList<>();
    private ArrayList<String> namaPerusahaan = new ArrayList<>();
    private ArrayList<String> alamatLowongan = new ArrayList<>();
    private ArrayList<String> minimalPendidikan = new ArrayList<>();
    private ArrayList<String> gaji = new ArrayList<>();
    private ArrayList<String> tenggatLowongan = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterLowongan(ArrayList<String> posisiLowongan, ArrayList<String> namaPerusahaan, ArrayList<String> alamatLowongan, ArrayList<String> minimalPendidikan, ArrayList<String> gaji, ArrayList<String> tenggatLowongan, Context context) {
        this.posisiLowongan = posisiLowongan;
        this.namaPerusahaan = namaPerusahaan;
        this.alamatLowongan = alamatLowongan;
        this.minimalPendidikan = minimalPendidikan;
        this.gaji = gaji;
        this.tenggatLowongan = tenggatLowongan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lowongan_kerja, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.posisiLowonganView.setText(posisiLowongan.get(position));
        holder.namaPerusahaanView.setText(namaPerusahaan.get(position));
        holder.alamatLowonganView.setText(alamatLowongan.get(position));
        holder.minimalPendidikanView.setText(minimalPendidikan.get(position));
        holder.gajiView.setText(gaji.get(position));
        holder.tenggatLowonganView.setText(tenggatLowongan.get(position));

//        holder.buttonLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.buttonLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, JobDetailActivity.class);

                intent.putExtra("posisi_lowongan", posisiLowongan.get(holder.getAdapterPosition()));
                intent.putExtra("nama_perusahaan", namaPerusahaan.get(holder.getAdapterPosition()));
                intent.putExtra("alamat_lowongan", alamatLowongan.get(holder.getAdapterPosition()));
                intent.putExtra("minimal_pendidikan", minimalPendidikan.get(holder.getAdapterPosition()));
                intent.putExtra("gaji", gaji.get(holder.getAdapterPosition()));
                intent.putExtra("tenggat_lowongan", tenggatLowongan.get(holder.getAdapterPosition()));

                context.startActivities(new Intent[]{intent});


            }
        });
    }

    @Override
    public int getItemCount() {
        return posisiLowongan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayoutItemLowonganKerja;
        TextView posisiLowonganView;
        TextView namaPerusahaanView;
        TextView alamatLowonganView;
        TextView minimalPendidikanView;
        TextView gajiView;
        TextView tenggatLowonganView;
        Button buttonLihat;
        Button buttonUbah;
        Button buttonHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemLowonganKerja = itemView.findViewById(R.id.linearLayoutItemLowonganKerja);
            posisiLowonganView = itemView.findViewById(R.id.posisiLowonganView);
            namaPerusahaanView = itemView.findViewById(R.id.namaPerusahaanView);
            alamatLowonganView = itemView.findViewById(R.id.alamatLowonganView);
            minimalPendidikanView = itemView.findViewById(R.id.minimalPendidikanView);
            gajiView = itemView.findViewById(R.id.gajiView);
            tenggatLowonganView = itemView.findViewById(R.id.tenggatLowonganView);
            buttonLihat = itemView.findViewById(R.id.buttonLihat);
            buttonUbah = itemView.findViewById(R.id.buttonUbah);
            buttonHapus = itemView.findViewById(R.id.buttonHapus);
        }
    }

}
