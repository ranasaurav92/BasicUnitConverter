package com.example.basicunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        EditText editText = findViewById(R.id.editTextNumberDecimal);
        TextView textView = findViewById(R.id.textView3);
        Button button = findViewById(R.id.button);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(v -> {

            closeKeyboard();

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
                            double newValue = value / 1.609;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = value * 3280.84;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = value * 39370.1;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = value * 100000;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Mile":
                    switch (spinnerText2) {

                        case "Km":
                            double newValue = value * 1.609;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            textView.setText(Double.toString(value));
                            break;

                        case "Foot":
                            newValue = value * 5280;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = value * 63360;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = value * 160934;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Foot":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = value / 3281;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = value / 5280;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            textView.setText(Double.toString(value));
                            break;

                        case "Inch":
                            newValue = value * 12;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Cm":
                            newValue = value * 30.48;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Inch":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = value / 39370;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = value / 63360;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = value / 12;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            textView.setText(Double.toString(value));
                            break;

                        case "Cm":
                            newValue = value * 2.54;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Cm":
                    switch (spinnerText2) {
                        case "Km":
                            double newValue = value / 100000;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Mile":
                            newValue = value / 160934;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Foot":
                            newValue = value / 30.48;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Inch":
                            newValue = value / 2.54;
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

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}