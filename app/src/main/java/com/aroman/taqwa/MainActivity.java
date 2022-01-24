package com.aroman.taqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    MaterialCardView cardSholatWajib, cardBacaanSholat, cardDoa, cardDzikir, cardAyatKursi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardSholatWajib = findViewById(R.id.cardSholatWajib);
        cardBacaanSholat = findViewById(R.id.cardBacaanSholat);
        cardDoa = findViewById(R.id.cardDoa);
        cardDzikir = findViewById(R.id.cardDzikir);
        cardAyatKursi = findViewById(R.id.cardAyatKursi);

        cardSholatWajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NiatSholat.class));
            }
        });

        cardBacaanSholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BacaanSholat.class));
            }
        });

        cardDoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Doa.class));
            }
        });

        cardDzikir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Dzikir.class));
            }
        });

        cardAyatKursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AyatKursi.class));
            }
        });


    }
}