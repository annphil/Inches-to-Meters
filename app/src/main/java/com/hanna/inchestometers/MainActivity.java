package com.hanna.inchestometers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    TextView resultText;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews()
    {
        inchesEditText = findViewById(R.id.edit_text_inches);
        resultText = findViewById(R.id.text_view_meters);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener()
    {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { ConvertToMeters(); }
        });
    }

    private void ConvertToMeters()
    {
        String inchesText = inchesEditText.getText().toString();
        if(inchesText.isEmpty())
            resultText.setText("Please enter a value to be converted");
        else
            {double inches = Integer.parseInt(inchesText);
            double meters = inches*0.0254;
            displayResult(meters); }
    }

    private void displayResult(double meters)
    {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersTextResult = myDecimalFormatter.format(meters);
        resultText.setText(metersTextResult + " meters");
    }
}

