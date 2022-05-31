package com.example.quizappfix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPahlawan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        String nama = getIntent().getStringExtra("NAMA");
        int foto = getIntent().getIntExtra("FOTO", 0);
        String detailPahlawan = getIntent().getStringExtra("DESKRIPSI");

        TextView detailNama = findViewById(R.id.detailNama);
        ImageView detailFoto = findViewById(R.id.detailFoto);
        TextView deskripsi = findViewById(R.id.detaildaripahlawan);

        detailNama.setText(nama);
        detailFoto.setImageResource(foto);
        deskripsi.setText(detailPahlawan);
    }
}