package com.example.findwork.pencarikerja;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.findwork.R;

import java.util.ArrayList;


public class FragmentTertarik extends Fragment {
    private ArrayList<String> profilePicturePelamar = new ArrayList<>();
    private ArrayList<String> namaPelamar = new ArrayList<>();
    private ArrayList<String> umurPelamar = new ArrayList<>();
    private ArrayList<String> emailPelamar = new ArrayList<>();

    public Button btn_lihat,btn_percakapan;
    Intent intent,intentt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tertarik, container, false);

        intent = new Intent(getActivity(), DetailLowonganHijau.class);
        intentt = new Intent(getActivity(), PercakapanPencariKerja.class);
        btn_percakapan = (Button) rootView.findViewById(R.id.btn_percakapan);
        btn_lihat = (Button) rootView.findViewById(R.id.btn_lihat);
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        btn_percakapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentt);
            }
        });

//        getDataPelamar();
        return rootView;
    }
}