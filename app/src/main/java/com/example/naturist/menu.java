package com.example.naturist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void descubrir (View view) {
        Intent descubrir = new Intent(menu.this, MapsActivity.class);
        startActivity(descubrir);
    }

    public void capturar (View view) {
        Intent capturar = new Intent(menu.this, activity_GPS.class);
        startActivity(capturar);
    }
}