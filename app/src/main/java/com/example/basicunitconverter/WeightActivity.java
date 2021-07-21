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

public class WeightActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        Objects.requireNonNull(getSupportActionBar()).hide();

        EditText editText = findViewById(R.id.editTextNumberDecimal);
        TextView textView = findViewById(R.id.textView3);
        Button button = findViewById(R.id.button);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(v -> {

            closeKeyboard();

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
                            double newValue = value * 2.205;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Ounce":
                            newValue = value * 35.274;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Pound":
                    switch (spinnerText2) {
                        case "Kg":
                            double newValue = value / 2.205;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;

                        case "Pound":
                            textView.setText(Double.toString(value));
                            break;

                        case "Ounce":
                            newValue = value * 16;
                            outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;
                    }
                    break;

                case "Ounce":
                    switch (spinnerText2) {
                        case "Kg":
                            double newValue = value / 35.274;
                            String outputValue = Double.toString(newValue);
                            textView.setText(outputValue);
                            break;


                        case "Pound":
                            newValue = value / 16;
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

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}