package com.example.quizappfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Pahlawan_RVInterface{

    ArrayList<ModelPahlawan> pahlawanModel = new ArrayList<>();

    int [] pahlawanFoto = {R.mipmap.untung_suropati,R.mipmap.cut_nyak_dien,R.mipmap.jendral_sudirman,
            R.mipmap.pangeran_diponegoro,R.mipmap.sutan_syahrir,R.mipmap.sukarno,R.mipmap.moh_hatta,
            R.mipmap.ra_kartini,R.mipmap.imam_bonjol,R.mipmap.ki_hajar_dewantara,R.mipmap.sultan_hasanuddin};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        setupModelPahlawan();

        Pahlawan_RVAdapter adapter = new Pahlawan_RVAdapter(this, pahlawanModel, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button kuis = findViewById(R.id.kuis);
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityToKuis();
            }
        });
    }

    private void changeActivityToKuis(){
        Intent intent = new Intent(this, QuizActivity.class);

        startActivity(intent);
    }

    private void setupModelPahlawan(){
        String[] namaPahlawans = getResources().getStringArray(R.array.judul_ensiklopedia);
        String[] deskripsi = getResources().getStringArray(R.array.detail_pahlawan);
        for (int i = 0; i < namaPahlawans.length; i++){
            pahlawanModel.add(new ModelPahlawan(namaPahlawans[i], pahlawanFoto[i], deskripsi[i]));
        }
    }

    @Override
    public void onButtonClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailPahlawan.class);

        intent.putExtra("NAMA", pahlawanModel.get(position).getPahlawanEnsiklopedia());
        intent.putExtra("FOTO", pahlawanModel.get(position).getImage());
        intent.putExtra("DESKRIPSI", pahlawanModel.get(position).getDetailPahlawan());
        startActivity(intent);
    }
}