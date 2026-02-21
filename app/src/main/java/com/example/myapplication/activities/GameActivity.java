package com.example.myapplication.activities;


import android.os.*;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.MLHelper;
import java.util.*;

public class GameActivity extends AppCompatActivity {

    View circle;
    long startTime;
    int currentRound = 1;
    int totalRounds = 10;
    List<Long> reactionTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        circle = findViewById(R.id.circle);

        startNextRound();

        circle.setOnClickListener(v -> {
            long reaction = System.currentTimeMillis() - startTime;
            reactionTimes.add(reaction);

            if(currentRound < totalRounds){
                currentRound++;
                startNextRound();
            } else {
                showResult();
            }
        });
    }

    private void startNextRound(){
        circle.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(() -> {
            circle.setVisibility(View.VISIBLE);
            startTime = System.currentTimeMillis();
        }, new Random().nextInt(3000) + 1000);
    }

    private void showResult(){
        double avg = reactionTimes.stream()
                .mapToLong(val -> val)
                .average()
                .orElse(0.0);

        String prediction = MLHelper.predict(avg);

        Toast.makeText(this,
                "Avg: " + avg + " ms\nRisk: " + prediction,
                Toast.LENGTH_LONG).show();
    }
}