package com.example.naturist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    public static final String user="names";
    TextView txtbienvenido;

    Button btncap;
    Button btndes;
    Button btnSub;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtbienvenido = (TextView) findViewById(R.id.txtbienvenido);
        String user = getIntent().getStringExtra("names");
        txtbienvenido.setText("¡Bienvenido"+ user +"!" );



        btncap = findViewById(R.id.btncap);
        btndes = findViewById(R.id.btndes);

        btncap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               Intent intent = new Intent(menu.this, activity_GPS.class);
                startActivity(intent);

            }

        }

        );



    }

}