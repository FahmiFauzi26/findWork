package com.example.findwork.perusahaan.modelpelamar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.findwork.R;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterPelamar extends RecyclerView.Adapter<RecyclerViewAdapterPelamar.ViewHolder> {

    private ArrayList<String> profilePicturePelamar = new ArrayList<>();
    private ArrayList<String> namaPelamar = new ArrayList<>();
    private ArrayList<String> umurPelamar = new ArrayList<>();
    private ArrayList<String> emailPelamar = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterPelamar(ArrayList<String> profilePicturePelamar, ArrayList<String> namaPelamar, ArrayList<String> umurPelamar, ArrayList<String> emailPelamar, Context context) {
        this.profilePicturePelamar = profilePicturePelamar;
        this.namaPelamar = namaPelamar;
        this.umurPelamar = umurPelamar;
        this.emailPelamar = emailPelamar;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelamar, parent, false);
        RecyclerViewAdapterPelamar.ViewHolder holder = new RecyclerViewAdapterPelamar.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(profilePicturePelamar.get(position)).into(holder.profilePicturePelamarView);
        holder.namaPelamarView.setText(namaPelamar.get(position));
        holder.umurPelamarView.setText(umurPelamar.get(position));
        holder.emailPelamarView.setText(emailPelamar.get(position));
    }

    @Override
    public int getItemCount() {
        return namaPelamar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView profilePicturePelamarView;
        TextView namaPelamarView;
        TextView umurPelamarView;
        TextView emailPelamarView;
        Button buttonLihatDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profilePicturePelamarView = itemView.findViewById(R.id.profilePicturePelamarView);
            namaPelamarView = itemView.findViewById(R.id.namaPelamarView);
            umurPelamarView = itemView.findViewById(R.id.alamatLowonganView);
            emailPelamarView = itemView.findViewById(R.id.emailPelamarView);
            buttonLihatDetail = itemView.findViewById(R.id.buttonLihatDetail);
        }
    }

}
