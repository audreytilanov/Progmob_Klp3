package com.example.quizappfix;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    TextView pertanyaan;
    Button jwb1, jwb2, jwb3, submitJwb;
    int nilai;
    int jumlahPertanyaan =  SoalKuis.kuis.length;
    int pertanyaanIndex = 0;
    String pilihan = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        pertanyaan = findViewById(R.id.pertanyaan);
        submitJwb = findViewById(R.id.submitJwb);
        jwb1 = findViewById(R.id.jwb1);
        jwb2 = findViewById(R.id.jwb2);
        jwb3 = findViewById(R.id.jwb3);

        pertanyaan.setOnClickListener(this);
        jwb1.setOnClickListener(this);
        jwb2.setOnClickListener(this);
        jwb3.setOnClickListener(this);
        submitJwb.setOnClickListener(this);

        loadPertanyaan();
    }

    @Override
    public void onClick(View view) {

        jwb1.setBackgroundColor(Color.BLACK);
        jwb2.setBackgroundColor(Color.BLACK);
        jwb3.setBackgroundColor(Color.BLACK);

        Button pilihanSubmit = (Button) view;
        if(pilihanSubmit.getId() == R.id.submitJwb){
            if (pilihan.equals(SoalKuis.jawaban[pertanyaanIndex])){
                nilai++;
            }
            pertanyaanIndex++;
            loadPertanyaan();
            loadPertanyaan();

        }else{
            pilihan = pilihanSubmit.getText().toString();
            pilihanSubmit.setBackgroundColor(Color.RED);
        }
    }

    void loadPertanyaan(){
        if(pertanyaanIndex == 3){
            selesai();
            return;
        }
        pertanyaan.setText(SoalKuis.kuis[pertanyaanIndex]);
        jwb1.setText(SoalKuis.pilihan[pertanyaanIndex][0]);
        jwb2.setText(SoalKuis.pilihan[pertanyaanIndex][1]);
        jwb3.setText(SoalKuis.pilihan[pertanyaanIndex][2]);

    }

    void selesai(){
        String status = "";
        if (nilai >=2 ){
            status = "Lulus";
        }else{
            status = "Gagal";
        }

        new AlertDialog.Builder(this)
                .setTitle(status)
                .setMessage("Jumlah Nilai "+ nilai)
                .setPositiveButton("Menu Utama", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(QuizActivity.this,MainActivity.class);
                        startActivity(intent);

                    }
                })
                .setCancelable(false)
                .show();
    }
}