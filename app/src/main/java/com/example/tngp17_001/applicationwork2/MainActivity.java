package com.example.tngp17_001.applicationwork2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean check;
    Button btn1;
    Button btn3;
    Button btn5;
    Button btn7;
    Button btn9;
    Button btn11;
    Button btnPlus;
    Button btnMinus;
    Button btnClear;
    TextView txtNumber;
    TextView txtOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        check = false;
        btn1 = (Button) findViewById(R.id.btn1);
        btn3 = (Button) findViewById(R.id.btn3);
        btn5 = (Button) findViewById(R.id.btn5);
        btn7 = (Button) findViewById(R.id.btn7);
        btn9 = (Button) findViewById(R.id.btn9);
        btn11 = (Button) findViewById(R.id.btn11);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnClear = (Button) findViewById(R.id.btnClear);
        txtNumber = (TextView) findViewById(R.id.txtNumber);
        txtOperator = (TextView) findViewById(R.id.txtOperator);
        btn1.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlus:
                txtOperator.setText("+");
                check = true;
                break;
            case R.id.btnMinus:
                txtOperator.setText("-");
                check = true;
                break;
            case R.id.btnClear:
                txtNumber.setText("");
                txtOperator.setText("");
                check = false;
                break;
            default:
                if (check) {
                    Button b = (Button)view;
                    int result = calculator(txtNumber.getText().toString(), b.getText().toString(), txtOperator.getText().toString());
                    txtNumber.setText(String.valueOf(result));
                }
                break;
        }
    }

    private int calculator(String number, String newNumber, String operator) {
        int result = 0;
        try {
            switch (operator) {
                case "+":
                    result = Integer.parseInt(number.equals("") ? "0" : number) + Integer.parseInt(newNumber);
                    break;
                case "-":
                    result = Integer.parseInt(number.equals("") ? "0" : number) - Integer.parseInt(newNumber);
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return (result < 0) ?  0 : result;
    }
}
