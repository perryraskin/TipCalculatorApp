package edu.qc.seclass.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity{

    Button buttonCompute;
    EditText checkAmountValue, partySizeValue;
    TextView checkAmount, partySize, fifteenPercentTipValue, twentyPercentTipValue, twentyfivePercentTipValue, fifteenPercentTotalValue, twentyPercentTotalValue, twentyfivePercentTotalValue;

    int checkAmountInput, partySizeInput, fifteenPercentVal, twentyPercentVal, twentyfivePercentVal, fifteenPercentTotalVal, twentyPercentTotalVal, twentyfivePercentTotalVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        buttonCompute = findViewById(R.id.buttonCompute);
        checkAmount = findViewById(R.id.checkAmount);
        partySize = findViewById(R.id.partySize);
        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Read input from app fields
                String checkField = checkAmountValue.getText().toString();
                String partyField = partySizeValue.getText().toString();

                if (checkField.length() <= 0 || partyField.length() <= 0) {
                    Toast t = Toast.makeText(TipCalculatorActivity.this, "Missing or invalid input.", Toast.LENGTH_SHORT);
                    t.show();
                } else {
                    // Parse to Integer to use for calculation
                    checkAmountInput = Integer.parseInt(checkField);
                    partySizeInput = Integer.parseInt(partyField);
                }

                if (checkAmountInput >= 1 && partySizeInput >= 1) {

                    // Calculate values according to tip percentages
                    fifteenPercentVal = (int) Math.round((checkAmountInput / partySizeInput) * .15);
                    twentyPercentVal = (int) Math.round((checkAmountInput / partySizeInput) * .2);
                    twentyfivePercentVal = (int) Math.round((checkAmountInput / partySizeInput) * .25);
                    fifteenPercentTotalVal = checkAmountInput / partySizeInput + fifteenPercentVal;
                    twentyPercentTotalVal = checkAmountInput / partySizeInput + twentyPercentVal;
                    twentyfivePercentTotalVal = checkAmountInput / partySizeInput + twentyfivePercentVal;

                    // Display the calculated values next to the corresponding percentage
                    fifteenPercentTipValue.setText(Integer.toString(fifteenPercentVal));
                    twentyPercentTipValue.setText(Integer.toString(twentyPercentVal));
                    twentyfivePercentTipValue.setText(Integer.toString(twentyfivePercentVal));
                    fifteenPercentTotalValue.setText(Integer.toString(fifteenPercentTotalVal));
                    twentyPercentTotalValue.setText(Integer.toString(twentyPercentTotalVal));
                    twentyfivePercentTotalValue.setText(Integer.toString(twentyfivePercentTotalVal));

                } else {

                    // Use Toast to check if the user enters an invalid number or leaves the field blank
                    Toast t = Toast.makeText(TipCalculatorActivity.this, "Missing or invalid input.", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }
}
