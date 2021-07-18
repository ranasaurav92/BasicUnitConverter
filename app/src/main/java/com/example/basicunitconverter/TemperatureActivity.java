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

public class TemperatureActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView textView = (TextView) findViewById(R.id.textView3);
        Button button = (Button) findViewById(R.id.button);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temp_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.temp_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(v -> {

            double value = Double.parseDouble(editText.getText().toString());

            String spinnerText = spinner.getSelectedItem().toString();
            String spinnerText2 = spinner2.getSelectedItem().toString();

            switch (spinnerText) {
                case "Celsius":
                    switch (spinnerText2) {
                        case "Celsius":
                            textView.setText(Double.toString(value));
                            break;

                        case "Kelvin":
                            double newValue = (double) (value + 273.15);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Fahrenheit":

                            newValue = (double) ((value * 1.8) + 32);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Kelvin":
                    switch (spinnerText2) {
                        case "Celsius":
                            double newValue = (double) (value - 273.15);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Kelvin":
                            textView.setText(Double.toString(value));
                            break;

                        case "Fahrenheit":
                            newValue = (double) ((value - 273.15) * 1.8 + 32);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Fahrenheit":
                    switch (spinnerText2) {
                        case "Celsius":
                            double newValue = (double) ((value - 32) * 0.555);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;


                        case "Kelvin":
                            newValue = (double) ((value - 32) * 0.555 + 273.15);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Fahrenheit":
                            textView.setText(Double.toString(value));
                            break;
                    }
                    break;
            }
        });

    }
}