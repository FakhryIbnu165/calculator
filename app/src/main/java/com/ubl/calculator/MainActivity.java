package com.ubl.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Number_1,Number_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Number_1 = findViewById(R.id.txtNumber1);
        Number_2 = findViewById(R.id.txtNumber2);

        findViewById(R.id.btnPlus).setOnClickListener(v -> handlePlusButton(this));
        findViewById(R.id.btnMinus).setOnClickListener(v -> handleMinusButton(this));
    }

    private void handlePlusButton(Context context) {
        if (validateInputs(context)) {
            double number1 = Double.parseDouble(Number_1.getText().toString());
            double number2 = Double.parseDouble(Number_2.getText().toString());
            double result = number1 + number2;

            showDialog(context, "Result", "The result of addition is: " + result);
        }
    }

    private void handleMinusButton(Context context) {
        if (validateInputs(context)) {
            double number1 = Double.parseDouble(Number_1.getText().toString());
            double number2 = Double.parseDouble(Number_2.getText().toString());
            double result = number1 - number2;

            showDialog(context, "Result", "The result of subtraction is: " + result);
        }
    }

    private boolean validateInputs(Context context) {
        if (Number_1.getText().toString().isEmpty()) {
            Toast.makeText(context, "Number 1 is required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Number_2.getText().toString().isEmpty()) {
            Toast.makeText(context, "Number 2 is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void showDialog(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}




