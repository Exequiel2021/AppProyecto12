package com.example.naturist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class giroscopio extends AppCompatActivity {

    TextView ejex;
    TextView ejey;
    TextView ejez;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giroscopio);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        ejex = findViewById(R.id.ejex);
        ejey = findViewById(R.id.ejey);
        ejez = findViewById(R.id.ejez);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

    }
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(gyroListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
}
        public void onStop(){
        super.onStop();

        sensorManager.unregisterListener(gyroListener);
        }

        public SensorEventListener gyroListener = new SensorEventListener(){
        @Override
            public void onSensorChanged(SensorEvent event){
                    float x = event.values[0];
                    float y = event.values[1];
                    float z = event.values[2];

                    ejex.setText("x: " + x );
                    ejey.setText("y: " + x );
                    ejez.setText("z: " + x );
        }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy){

            }
        };
    }