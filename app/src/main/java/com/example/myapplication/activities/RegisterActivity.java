package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.activities.HomeActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String age = etAge.getText().toString();

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            startActivity(intent);
        });
    }
}