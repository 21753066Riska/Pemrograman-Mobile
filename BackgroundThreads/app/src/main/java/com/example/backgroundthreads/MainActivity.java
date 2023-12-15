package com.example.backgroundthreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        TextView tvStatus = findViewById(R.id.tv_status);

        btnStart.setOnClickListener(v -> {
            try {
                for (int i = 0; i <=10; i++) {
                    Thread.sleep(500);
                    int percentage = i * 10;
                    if (percentage == 100){
                        tvStatus.setText("Task Complated");
                    } else {
                        tvStatus.setText(String.format("Compressing %d %%", percentage));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}