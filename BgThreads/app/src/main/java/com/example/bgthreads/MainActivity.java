package com.example.bgthreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        TextView tvStatus = findViewById(R.id.tv_status);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        btnStart.setOnClickListener(v -> {
            executor.execute(() -> {
                try {
                    for (int i = 0; i <= 10; i++) {
                        Thread.sleep(500);
                        int percentage = i * 10;
                        handler.post(() -> {
                            if (percentage == 100) {
                                tvStatus.setText("Task Complated");
                            } else {
                                tvStatus.setText(String.format("Compressing %d %%", percentage));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}