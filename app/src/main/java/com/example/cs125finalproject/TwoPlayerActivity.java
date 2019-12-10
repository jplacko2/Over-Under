package com.example.cs125finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TwoPlayerActivity extends AppCompatActivity implements SensorEventListener {

    private Random rng = new Random();
    private ImageView die1;
    private ImageView die2;
    private ImageView die3;
    private ImageView die4;
    private ImageView die5;
    private ImageView die6;
    private ImageView[] diceArray;
    private Spinner playerGuess;
    private double compareValue;
    private TextView compareValueText;
    private int rollValue;
    private int playerOneScore;
    private int playerTwoScore;
    private int playerNum;
    private TextView playerOneUpdateScore;
    private TextView playerTwoUpdateScore;
    private ImageView winner;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static final double ACCELERATION_THRESHOLD = 7;
    private TextView whichPlayer;


    protected void onCreate(Bundle savedInstanceStats) {
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.activity_two_player);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        die1 = findViewById(R.id.diceView);
        die2 = findViewById(R.id.diceView1);
        die3 = findViewById(R.id.diceView2);
        die4 = findViewById(R.id.diceView3);
        die5 = findViewById(R.id.diceView4);
        die6 = findViewById(R.id.diceView5);
        playerNum = 0;
        whichPlayer = findViewById(R.id.playerNumberText);
        whichPlayer.setText("Player 1");
        diceArray = new ImageView[]{die1, die2, die3, die4, die5, die6};
        playerGuess = findViewById(R.id.playerResponseSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.game_choices));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerGuess.setAdapter(spinnerAdapter);
        compareValueText = findViewById(R.id.numToCompare);
        compareValue = getRandomCompareValue();
        compareValueText.setText(Integer.toString((int) compareValue));
        playerOneUpdateScore = findViewById(R.id.playerScore);
        playerTwoUpdateScore = findViewById(R.id.playerScore2);
        winner = findViewById(R.id.winner);
        winner.setVisibility(View.GONE);
        Button roll = findViewById(R.id.roll);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollButton();
                }
            });
        Button reset = findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerOneScore = 0;
                playerOneUpdateScore.setText("Player 1's Score: " + playerOneScore);
                playerTwoScore = 0;
                playerTwoUpdateScore.setText("Player 2's Score: " + playerTwoScore);
                playerNum = 0;
                whichPlayer.setText("Player 1");
                compareValue = getRandomCompareValue();
                compareValueText.setText(Integer.toString((int) compareValue));
                for (ImageView eachDie : diceArray) {
                    eachDie.setVisibility(View.VISIBLE);
                }
                winner.setVisibility(View.GONE);
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
    private double playerPointsWon() {
        double points = 0;
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
        } else {
            points = 0;
        }
        return points;
    }

    private long startTime = 0;
    private static final long MIN_MILLISECONDS_DELAY = 800;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mAccelerometer) {
            float[] accelValues = sensorEvent.values;
            double totalAcc = Math.sqrt(accelValues[0]*accelValues[0]
                    + accelValues[1]*accelValues[1] + accelValues[2]*accelValues[2]);
            if (totalAcc > ACCELERATION_THRESHOLD) {

                long currentTime = System.currentTimeMillis();

                if(currentTime - startTime > MIN_MILLISECONDS_DELAY) {
                    rollButton();
                }

                startTime = System.currentTimeMillis();

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
        int x = 0;
        while (x < 1000000000) {
            for (int i = 0; i < 1000; i++) {
                x = x;
            }
            x++;
        }
    }
    private void rollButton() {
        rollValue = rollSix();
        if (playerNum % 2 == 0) {
            playerOneScore += playerPointsWon();
            playerOneUpdateScore.setText("Player 1's Score: " + playerOneScore);
            whichPlayer.setText("Player 2");
        } else {
            playerTwoScore += playerPointsWon();
            playerTwoUpdateScore.setText("Player 2's Score: " + playerTwoScore);
            whichPlayer.setText("Player 1");
        }
        playerNum++;
        compareValue = getRandomCompareValue();
        compareValueText.setText(Integer.toString((int) compareValue));
        if (playerOneScore >= 200 && playerTwoScore >= 200) {
            if (playerOneScore > playerTwoScore) {
                for (ImageView eachDie : diceArray) {
                    eachDie.setVisibility(View.GONE);
                }
                winner.setImageResource(R.drawable.player1wins);
                winner.setVisibility(View.VISIBLE);
            } else {
                for (ImageView eachDie : diceArray) {
                    eachDie.setVisibility(View.GONE);
                }
                winner.setImageResource(R.drawable.player2wins);
                winner.setVisibility(View.VISIBLE);
            }
        } else if (playerOneScore >= 200) {
            for (ImageView eachDie : diceArray) {
                eachDie.setVisibility(View.GONE);
            }
            winner.setImageResource(R.drawable.player1wins);
            winner.setVisibility(View.VISIBLE);
        } else if (playerTwoScore >= 200){
            for (ImageView eachDie : diceArray) {
                eachDie.setVisibility(View.GONE);
            }
            winner.setImageResource(R.drawable.player2wins);
            winner.setVisibility(View.VISIBLE);
        }
    }
}
