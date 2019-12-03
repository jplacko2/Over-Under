package com.example.cs125finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ImageView diceView;
    private Random rng = new Random();
    private Button rollButton;
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
