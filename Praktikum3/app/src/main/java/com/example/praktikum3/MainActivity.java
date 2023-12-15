package com.example.praktikum3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == MOveForResultActivity.RESULT_CODE && result.getData()
        !=null) {
            int selectedValue = result.getData().getIntExtra(MOveForResultActivity.EXTRA_SELECTED_VALUE,0);
            tvResult.setText(String.format("Hasil: %s",selectedValue));
        }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);

        btnMoveActivity.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_move_activity){
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.btn_move_activity_data){
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KULIAH, "Pemrograman Berbasis Mobile");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_KELAS, 5);
            startActivity(moveWithDataIntent);
        } else if (view.getId() == R.id.btn_dial_number){
            String phoneNumber = "081210841382";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phoneNumber));
            startActivity(dialPhoneIntent);
        } else if (view.getId() == R.id.btn_move_for_result) {
            Intent moveForResultIntent = new Intent(MainActivity.this, MOveForResultActivity.class);
            resultLauncher.launch(moveForResultIntent);
        }


    }
}