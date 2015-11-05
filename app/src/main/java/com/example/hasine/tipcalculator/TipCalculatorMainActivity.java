package com.example.hasine.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TipCalculatorMainActivity extends AppCompatActivity {

    private EditText pprice;
    private TextView finaltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize Radio group and attach click handles */
        pprice = (EditText) findViewById(R.id.price);
        finaltext = (TextView) findViewById(R.id.finalText);
    }

    public void calculate(View view) {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        if (TextUtils.isEmpty(pprice.getText().toString())) {
            return;
        }
        Double result = 0.0;
        Double Price = Double.parseDouble(pprice.getText().toString());

        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.yess:
                    result = 0.15 * Price;
                           break;
            case R.id.naah:
                    result = 0.10 * Price;
                    break;
            case R.id.noo:
                    result = 0.05 * Price;
                    break;
        }
        finaltext.setVisibility(View.VISIBLE);
        DecimalFormat df = new DecimalFormat("#0.00");
        finaltext.setText(getString(R.string.finalamount) + df.format(result));
    }
}