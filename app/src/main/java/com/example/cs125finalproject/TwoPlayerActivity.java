package com.example.cs125finalproject;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TwoPlayerActivity extends AppCompatActivity {

    private Random rng = new Random();
    private ImageView die1;
    private ImageView die2;
    private ImageView die3;
    private ImageView die4;
    private ImageView die5;
    private ImageView die6;
    private ImageView[] diceArray;
    private Spinner playerGuess;
    private int compareValue;
    private TextView compareValueText;
    private int rollValue;


    protected void onCreate(Bundle savedInstanceStats) {
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.activity_two_player);

        die1 = findViewById(R.id.diceView);
        die2 = findViewById(R.id.diceView1);
        die3 = findViewById(R.id.diceView2);
        die4 = findViewById(R.id.diceView3);
        die5 = findViewById(R.id.diceView4);
        die6 = findViewById(R.id.diceView5);

        diceArray = new ImageView[]{die1, die2, die3, die4, die5, die6};

        playerGuess = findViewById(R.id.playerResponseSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.game_choices));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerGuess.setAdapter(spinnerAdapter);
        compareValueText = findViewById(R.id.numToCompare);
        compareValue = getRandomCompareValue();
        compareValueText.setText(Integer.toString(compareValue));
        Button roll = findViewById(R.id.roll);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollValue = rollSix();
            }
        });

    }
    private int roll(ImageView diceView) {
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
        return random;
    }
    private int rollSix() {
        int countForTurn = 0;
        for (ImageView eachDie : diceArray) {
            int result = roll(eachDie);
            countForTurn+= result;
        }
        return countForTurn;
    }

    /**
     * This will give the value that we compare to for over and under.
     * @return a number between 8 and 34
     */
    private int getRandomCompareValue() {
        return rng.nextInt(27) + 8;
    }
    private void updateUI() {

    }
    private int playerPointsWon() {
        int points = 0;
        String playerChoice = playerGuess.getSelectedItem().toString();
        if (playerChoice.equals("Equal") && rollValue == compareValue) {
            points = 75;
        } else if (playerChoice.equals("Smaller") && rollValue < compareValue) {
            points = 36 - compareValue;
        } else if (playerChoice.equals("Much Smaller") && rollValue < (compareValue + 6) / 2) {
            points = (36 - compareValue) * 2;
        } else if (playerChoice.equals("Larger") && rollValue > compareValue) {
            points = compareValue;
        } else if (playerChoice.equals("Much Larger") && rollValue > compareValue + ((compareValue - 6) / 2)) {
            points = compareValue * 2;
        }
        return points;
    }
}
