package com.example.cs125finalproject;

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
    /*private ImageView diceView;
    private Button rollButton;
    private TextView sidesPerDieText;
    private SeekBar sidesPerDieBar;
    private TextWatcher sidesDieTW;
    private EditText sidesPerDieEdit;
    private TextView numberOfDiceText;
    private SeekBar numberOfDiceBar;
    private TextWatcher numDiceTW;
    private EditText numberOfDiceEdit;
    private final int defaultNumSides = 6;
    private final int defaultNumDice = 1;*/
    private Button playButton;
    //private SensorManager mSensorManager;
    //private Sensor mAccelerometer;
    //private static final double ACCELERATION_THRESHOLD = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityButton();
            }
        });
        //mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        //mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }
    private void startActivityButton() {
        Intent intent = new Intent(this, TwoPlayerActivity.class);
        startActivity(intent);
    }
    /*
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mAccelerometer) {
            float[] accelValues = sensorEvent.values;
            double totalAcc = Math.sqrt(accelValues[0]*accelValues[0]
                    + accelValues[1]*accelValues[1] + accelValues[2]*accelValues[2]);
            if (totalAcc > ACCELERATION_THRESHOLD) {
                //do the thing
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        return;
    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    */
    //diceView = findViewById(R.id.diceView);
        /*diceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll();
            }
        });
        rollButton = findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
        sidesPerDieText = findViewById(R.id.sidesPerDieText);
        sidesPerDieBar = findViewById(R.id.sidesPerDieBar);
        sidesPerDieEdit = findViewById(R.id.sidesPerDieEdit);
        sidesPerDieEdit.setText(Integer.toString(defaultNumSides));
        sidesPerDieEdit.addTextChangedListener(sidesDieTW);
        sidesDieTW = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Integer.parseInt(charSequence.toString()) < 2) {
                    sidesPerDieBar.setProgress(0);
                } else if (Integer.parseInt(charSequence.toString()) > 20) {
                    sidesPerDieBar.setProgress(18);
                }
                sidesPerDieBar.setProgress(Integer.parseInt(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        sidesPerDieBar.setProgress(defaultNumSides - 2);
        sidesPerDieBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sidesPerDieEdit.setText(Integer.toString(i + 2));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        numberOfDiceText = findViewById(R.id.numberOfDiceText);
        numberOfDiceBar = findViewById(R.id.numberOfDiceBar);
        numberOfDiceEdit = findViewById(R.id.numberOfDiceEdit);
        numberOfDiceEdit.setText(Integer.toString(defaultNumDice));
        numberOfDiceEdit.addTextChangedListener(numDiceTW);
        numDiceTW = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        numberOfDiceBar.setProgress(defaultNumDice - 1);
        numberOfDiceBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                numberOfDiceEdit.setText(Integer.toString(i + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}*/
}