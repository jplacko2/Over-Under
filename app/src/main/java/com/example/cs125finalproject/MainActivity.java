package com.example.cs125finalproject;

import android.content.Intent;
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
    }
    private void startActivityButton() {
        Intent intent = new Intent(this, TwoPlayerActivity.class);
        startActivity(intent);
    }
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