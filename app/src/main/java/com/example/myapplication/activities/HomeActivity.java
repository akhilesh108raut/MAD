package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnStart = findViewById(R.id.btnStartGame);
        Button btnDash = findViewById(R.id.btnDashboard);

        btnStart.setOnClickListener(v ->
                startActivity(new Intent(this, GameActivity.class)));

        btnDash.setOnClickListener(v ->
                startActivity(new Intent(this, DashBoardActivity.class)));
    }
}