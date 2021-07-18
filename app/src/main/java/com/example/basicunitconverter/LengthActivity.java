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

public class LengthActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText = (EditText) findViewById(R.id.editTextNumberDecimal);
        TextView textView = (TextView) findViewById(R.id.textView3);
        Button button = (Button) findViewById(R.id.button);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(v -> {

            double value = Double.parseDouble(editText.getText().toString());

            String spinnerText = spinner.getSelectedItem().toString();
            String spinnerText2 = spinner2.getSelectedItem().toString();

            switch (spinnerText) {
                case "Km":
                    switch (spinnerText2) {
                        case "Km":
                            textView.setText(Double.toString(value));
                            break;

                        case "Mile":
                            double newValue = (double) (value / 1.609);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = (double) (value * 3280.84);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = (double) (value * 39370.1);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = (double) (value * 100000);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Mile":
                    switch (spinnerText2) {

                        case "Km":
                            double newValue = (double) (value * 1.609);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            textView.setText(Double.toString(value));
                            break;

                        case "Foot":
                            newValue = (double) (value * 5280);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = (double) (value * 63360);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = (double) (value * 160934);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Foot":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = (double) (value / 3281);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = (double) (value / 5280);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            textView.setText(Double.toString(value));
                            break;

                        case "Inch":
                            newValue = (double) (value * 12);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = (double) (value * 30.48);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Inch":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = (double) (value / 39370);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = (double) (value / 63360);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = (double) (value / 12);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            textView.setText(Double.toString(value));
                            break;

                        case "Cm":
                            newValue = (double) (value * 2.54);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Cm":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = (double) (value / 100000);
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = (double) (value / 160934);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = (double) (value / 30.48);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = (double) (value / 2.54);
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            textView.setText(Double.toString(value));
                            break;
                    }
                    break;
            }
        });


    }
}