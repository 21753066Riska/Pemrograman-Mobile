package com.example.activity_21753066;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editWidth, editHeight, editLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWidth = findViewById(R.id.edit_width);
        editHeight = findViewById(R.id.edit_height);
        editLength = findViewById(R.id.edit_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public  void onClick(View v) {
        if (v.getId() == R.id.btn_calculate){
            String inputLength = editLength.getText().toString().trim();
            String inputWidth = editWidth.getText().toString().trim();
            String inputHeight = editHeight.getText().toString().trim();

            Double volume = Double.parseDouble(inputLength) *
                    Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
            tvResult.setText(String.valueOf(volume));
        }
    }
}