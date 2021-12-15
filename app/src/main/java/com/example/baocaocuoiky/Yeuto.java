package com.example.baocaocuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Yeuto extends AppCompatActivity {
    Button bt_khaibao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinyeuto);
        bt_khaibao= findViewById(R.id.kb);

        bt_khaibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Yeuto.this, TrangChu.class);
                startActivity(intent);
            }
        });

    }
}
