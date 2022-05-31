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
        
        String detailPahlawan = getIntent().getStringExtra("DESKRIPSI");
        int foto = getIntent().getIntExtra("FOTO", 0);
        String nama = getIntent().getStringExtra("NAMA");
        
        TextView deskripsi = findViewById(R.id.detaildaripahlawan);
        ImageView detailFoto = findViewById(R.id.detailFoto);
        TextView detailNama = findViewById(R.id.detailNama);

        detailNama.setText(nama);
        detailFoto.setImageResource(foto);
        deskripsi.setText(detailPahlawan);
    }
}
