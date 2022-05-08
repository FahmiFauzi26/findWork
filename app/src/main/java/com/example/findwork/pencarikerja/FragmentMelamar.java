package com.example.findwork.pencarikerja;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.findwork.R;
import com.example.findwork.perusahaan.DetailPelamarActivity;

import java.util.ArrayList;



public class FragmentMelamar extends Fragment {

    private ArrayList<String> profilePicturePelamar = new ArrayList<>();
    private ArrayList<String> namaPelamar = new ArrayList<>();
    private ArrayList<String> umurPelamar = new ArrayList<>();
    private ArrayList<String> emailPelamar = new ArrayList<>();

    public Button btn_lihat;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_melamar, container, false);

        intent = new Intent(getActivity(), DetailLowonganHijau.class);
        btn_lihat = (Button) rootView.findViewById(R.id.btn_lihat);
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

//        getDataPelamar();
        return rootView;
    }

//    private void prosesRecyclerViewAdapterPelamar(@NonNull View view, Context context) {
//        RecyclerView recyclerView = view.findViewById(R.id.recycleViewDaftarLowongan);
//        RecyclerViewAdapterPelamar adapter = new RecyclerViewAdapterPelamar(profilePicturePelamar, namaPelamar, umurPelamar, emailPelamar, this);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    private void getDataPelamar() {
//        profilePicturePelamar.add("https://randomuser.me/api/portraits/women/90.jpg");
//        namaPelamar.add("Tasya Kaila");
//        umurPelamar.add("23 Tahun");
//        emailPelamar.add("tasyakaila17@gmail.com");
//
//        profilePicturePelamar.add("https://randomuser.me/api/portraits/men/32.jpg");
//        namaPelamar.add("Baharudin");
//        umurPelamar.add("24 Tahun");
//        emailPelamar.add("baharudin17@gmail.com");
//
//        profilePicturePelamar.add("https://randomuser.me/api/portraits/men/11.jpg");
//        namaPelamar.add("Thomas");
//        umurPelamar.add("27 Tahun");
//        emailPelamar.add("thomas17@gmail.com");
//
//        prosesRecyclerViewAdapterPelamar();
//    }
}