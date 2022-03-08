package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final String TAG = "main activity";
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

    private HashMap<String, Integer> calcMap = new HashMap<>();
    private String[] funcOpt = {"x", "%", "+", "-"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setClickListeners();
    }

    private void setClickListeners() {
        main_EDT_first_number.setOnClickListener(e -> handleNumberInput(1));
        main_EDT_second_number.setOnClickListener(e -> handleNumberInput(2));
        main_CMB_func_opt.setOnClickListener(e -> handleFuncInput());
        main_BTN_calc.setOnClickListener(e -> handleCalcBtn());
    }

    private void handleCalcBtn() {
    }

    private void handleFuncInput() {
        try{
            funcStr = main_CMB_func_opt.get
        }catch (Exception e){
            Log.e(TAG ,"failed to parse string to int", e.getCause());
            return;
        }
    }

    private void handleNumberInput(int index) {
        String numStr = "";
        int value = 0 ;
        switch (index){
            case 1:
                numStr = main_EDT_first_number.getText().toString();
                try {
                    value = Integer.parseInt(numStr);
                }catch(Exception e){
                    Log.e(TAG ,"failed to parse string to int", e.getCause());
                    return;
                }
                calcMap.put("first", value);
                break;
            case 2:
                numStr = main_EDT_second_number.getText().toString();
                try {
                    value = Integer.parseInt(numStr);
                }catch(Exception e){
                    Log.e(TAG ,"failed to parse string to int", e.getCause());
                    return;
                }
                calcMap.put("second", value);
                break;
        }
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