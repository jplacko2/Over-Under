package com.example.cs125finalproject;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView diceView;
    private Random rng = new Random();
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
    private final int defaultNumDice = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diceView = findViewById(R.id.diceView);
        diceView.setOnClickListener(new View.OnClickListener() {
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
        /*sidesPerDieEdit.addTextChangedListener(sidesDieTW);
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
        };*/
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
        /*numberOfDiceEdit.addTextChangedListener(numDiceTW);
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
        };*/
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
    private void roll() {
        int random = rng.nextInt(6) + 1;
        if (random == 1) {
            diceView.setImageResource(R.drawable.side1);
        } else if (random == 2) {
            diceView.setImageResource(R.drawable.side2);
        } else if (random == 3) {
            diceView.setImageResource(R.drawable.side3);
        } else if (random == 4) {
            diceView.setImageResource(R.drawable.side4);
        } else if (random == 5) {
            diceView.setImageResource(R.drawable.side5);
        } else if (random == 6) {
            diceView.setImageResource(R.drawable.side6);
        }
    }
}
