package com.example.basicunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class WeightActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView textView = (TextView) findViewById(R.id.textView3);
        Button button = (Button) findViewById(R.id.button);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(v -> {

            double value = Double.parseDouble(editText.getText().toString());

            String spinnerText = spinner.getSelectedItem().toString();
            String spinnerText2 = spinner2.getSelectedItem().toString();

            switch (spinnerText) {
                case "Kg":
                    switch (spinnerText2) {
                        case "Kg":
                            textView.setText(Double.toString(value));
                            break;

                        case "Pound":
                            double newValue = (double) (value * 2.205);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Ounce":
                            newValue = (double) (value * 35.274);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Pound":
                    switch (spinnerText2) {
                        case "Kg":
                            double newValue = (double) (value / 2.205);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Pound":
                            textView.setText(Double.toString(value));
                            break;

                        case "Ounce":
                            newValue = (double) (value * 16);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Ounce":
                    switch (spinnerText2) {
                        case "Kg":
                            double newValue = (double) (value / 35.274);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;


                        case "Pound":
                            newValue = (double) (value / 16);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Ounce":
                            textView.setText(Double.toString(value));
                            break;
                    }
                    break;
            }
        });
    }
}