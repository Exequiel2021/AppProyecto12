package com.example.naturist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class activity_GPS extends AppCompatActivity {
    TextView txlatitud;
    TextView txlongitud;
    TextView txdireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        txlatitud = (TextView) findViewById(R.id.txlatitud);
        txlongitud = (TextView) findViewById(R.id.txlongitud);
        txdireccion = (TextView) findViewById(R.id.txdireccion);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
        )
        {}else{
            locationStart();
        }

    }


    }
