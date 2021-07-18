package com.example.basicunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WeightActivity.class);
            MainActivity.this.startActivity(intent);
        });

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LengthActivity.class);
            startActivity(intent);
        });

        button5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TemperatureActivity.class);
            startActivity(intent);
        });

    }
}