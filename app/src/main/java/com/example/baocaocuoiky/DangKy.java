package com.example.baocaocuoiky;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DangKy extends AppCompatActivity {
    Button bt_layotp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        bt_layotp= findViewById(R.id.opt);

        bt_layotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, layOTP.class);
                startActivity(intent);
            }
        });

    }
}
