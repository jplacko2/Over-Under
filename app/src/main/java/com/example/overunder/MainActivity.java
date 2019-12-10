package com.example.overunder;

import android.content.Intent;
/*import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;*/
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityButton();
            }
        });

    }
    private void startActivityButton() {
        Intent intent = new Intent(this, com.example.overunder.GameRules.class);
        startActivity(intent);
    }
}