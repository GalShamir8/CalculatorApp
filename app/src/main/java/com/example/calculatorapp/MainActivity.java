package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    //first layout
    private EditText main_EDT_first_number;
    private EditText main_EDT_second_number;
    private Spinner main_CMB_func_opt;
    private MaterialButton main_BTN_calc;

    //second layout
    private TextView main_TXT_first_number;
    private TextView main_TXT_function;
    private TextView main_TXT_second_number;

    //third layout
    private TextView main_TXT_result;

    //forth layout
    private EditText main_EDT_name;
    private EditText main_EDT_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        main_EDT_first_number = findViewById(R.id.main_EDT_first_number);
        main_EDT_second_number = findViewById(R.id.main_EDT_second_number);
        main_CMB_func_opt = findViewById(R.id.main_CMB_func_opt);
        main_BTN_calc = findViewById(R.id.main_BTN_calc);
        main_TXT_first_number = findViewById(R.id.main_TXT_first_number);
        main_TXT_function = findViewById(R.id.main_TXT_function);
        main_TXT_second_number = findViewById(R.id.main_TXT_second_number);
        main_TXT_result = findViewById(R.id.main_TXT_result);
        main_EDT_name = findViewById(R.id.main_EDT_name);
        main_EDT_id = findViewById(R.id.main_EDT_id);
    }
}