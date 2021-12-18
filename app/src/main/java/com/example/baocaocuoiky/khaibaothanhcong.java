package com.example.baocaocuoiky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.baocaocuoiky.databinding.KhaibaoBinding;

public class khaibaothanhcong extends Activity {
   Button bt_quayve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khaibaothanhcong);
        bt_quayve = findViewById(R.id.trove);

        bt_quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(khaibaothanhcong.this,TrangChu.class);
                startActivity(intent);
            }
        });
    }
}

