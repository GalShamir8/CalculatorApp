package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "main activity";
    //first layout
    private EditText main_EDT_first_number;
    private EditText main_EDT_second_number;
    private EditText main_EDT_func_opt;
    private MaterialButton main_BTN_calc;

    //second layout
    private TextView main_TXT_first_number;
    private TextView main_TXT_function;
    private TextView main_TXT_second_number;

    //third layout
    private TextView main_TXT_result;

    private HashMap<String, String> calcMap = new HashMap<>();
    private ArrayList<String> validFuncInputs= new ArrayList<>(Arrays.asList("+", "x", "%", "-"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setClickListeners();
    }

    private void setClickListeners() {
        main_BTN_calc.setOnClickListener(e -> handleCalcBtn());
    }

    private void handleCalcBtn() {
        handleFuncInput();
        handleNumberInput(1);
        handleNumberInput(2);
        if(validate()){
            handleNumberInput(1);
            handleNumberInput(2);
            String firstVal = calcMap.get("first");
            String secondVal = calcMap.get("second");
            String func = calcMap.get("func");
            String result = calcResult(firstVal, secondVal, func);
            main_TXT_first_number.setText(firstVal);
            main_TXT_second_number.setText(secondVal);
            main_TXT_function.setText(func);
            main_TXT_result.setText(result);
        }else{
            Log.i(TAG, "input required");
            toastMessage("input required");
        }
    }

    private void toastMessage(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL|Gravity.TOP,
                0, 0);
        toast.show();
    }

    private String calcResult(String firstVal, String secondVal, String func) {
        String result = "";
        double res = 0;
        try{
            int first = Integer.parseInt(firstVal);
            int second = Integer.parseInt(secondVal);
            switch (func){
                case "+":
                    res = first + second;
                    break;

                case "-":
                    res = first - second;
                    break;

                case "x":
                    res = first * second;
                    break;

                case "%":
                        if(second != 0){
                            res = (double)first/second;
                        }
                        else{
                            toastMessage("Can not divide by zero!");
                        }
                    break;
            }
            if(res % 10 == 0){
                res = (int)res;
            }
            result = "" + res;
        }catch (NumberFormatException e){
            Log.e(TAG, "failed to parse string to int", e.getCause());
            return "";
        }
        return result;
    }

    private boolean validate() {
        String firstInput = main_EDT_first_number.getText().toString();
        String secondInput = main_EDT_second_number.getText().toString();
        String funcInput = main_EDT_func_opt.getText().toString();

        boolean inputFlag = !firstInput.isEmpty() &&
                !secondInput.isEmpty() &&
                !funcInput.isEmpty();

        boolean hashMapFlag = calcMap.get("first") != null &&
                calcMap.get("second") != null &&
                calcMap.get("func") != null;

        return inputFlag && hashMapFlag;
    }

    private void handleFuncInput() {
        try{
            String funcInput = main_EDT_func_opt.getText().toString();
            if(validFuncInputs.contains(funcInput)){
                calcMap.put("func", funcInput);
            }

        }catch (Exception e){
            Log.e(TAG ,"failed to parse string to int", e.getCause());
        }
    }

    private void handleNumberInput(int index) {
        String numStr = "";
        switch (index){
            case 1:
                numStr = main_EDT_first_number.getText().toString();
                if(!numStr.isEmpty()) {
                    calcMap.put("first", numStr);
                }
                break;
            case 2:
                numStr = main_EDT_second_number.getText().toString();
                if(!numStr.isEmpty()) {
                    calcMap.put("second", numStr);
                }
                break;
        }
    }

    private void setViews() {
        main_EDT_first_number = findViewById(R.id.main_EDT_first_number);
        main_EDT_second_number = findViewById(R.id.main_EDT_second_number);
        main_EDT_func_opt = findViewById(R.id.main_CMB_func_opt);
        main_BTN_calc = findViewById(R.id.main_BTN_calc);
        main_TXT_first_number = findViewById(R.id.main_TXT_first_number);
        main_TXT_function = findViewById(R.id.main_TXT_function);
        main_TXT_second_number = findViewById(R.id.main_TXT_second_number);
        main_TXT_result = findViewById(R.id.main_TXT_result);
    }

}