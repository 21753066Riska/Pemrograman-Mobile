package com.example.praktikum3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MOveForResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnChoose;
    private RadioGroup rgNumber;
    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE =110;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnChoose = findViewById(R.id.btn_choose);
        rgNumber = findViewById(R.id.rg_number);
        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_choose) {
            if (rgNumber.getCheckedRadioButtonId() !=0){
                int value = 0;
                int id = rgNumber.getCheckedRadioButtonId();

                if (id == R.id.rb_50) {
                    value = 50;
                } else if (id == R.id.rb_100) {
                    value = 100;
                } else if (id == R.id.rb_150) {
                    value = 150;
                } else if (id == R.id.rb_200) {
                    value = 200;
                }

                Intent resultIntent=new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}