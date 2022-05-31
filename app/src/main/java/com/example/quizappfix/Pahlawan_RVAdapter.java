package com.example.quizappfix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pahlawan_RVAdapter extends RecyclerView.Adapter<Pahlawan_RVAdapter.MyViewHolder> {

    private final Pahlawan_RVInterface pahlawanRvInterface;

    Context context;
    ArrayList<ModelPahlawan> pahlawanModel;

    public Pahlawan_RVAdapter(Context context, ArrayList<ModelPahlawan> pahlawanModel, Pahlawan_RVInterface pahlawanRvInterface){
        this.context = context;
        this.pahlawanModel = pahlawanModel;
        this.pahlawanRvInterface = pahlawanRvInterface;
    }
    @NonNull
    @Override
    public Pahlawan_RVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_row, parent, false);

        return new Pahlawan_RVAdapter.MyViewHolder(view, pahlawanRvInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Pahlawan_RVAdapter.MyViewHolder holder, int position) {
        holder.nama.setText(pahlawanModel.get(position).getPahlawanEnsiklopedia());
//        holder.deskripsi.setText(pahlawanModel.get(position).getPahlawanEnsiklopedia());
        holder.imageView.setImageResource(pahlawanModel.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return pahlawanModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nama, deskripsi;
        Button detailPahlawanbtn;

        public MyViewHolder(@NonNull View itemView, Pahlawan_RVInterface pahlawanRvInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            nama = itemView.findViewById(R.id.textView);
            detailPahlawanbtn = itemView.findViewById(R.id.detailPahlawanbtn);
//            deskripsi = itemView.findViewById(R.id.textView);

            detailPahlawanbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(pahlawanRvInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            pahlawanRvInterface.onButtonClick(pos);
                        }
                    }
                }
            });
        }
    }
}
