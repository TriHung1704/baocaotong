package com.example.baocaocuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class layOTP extends AppCompatActivity {
        Button bt_xacnhan;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.xacthuc);
            bt_xacnhan= findViewById(R.id.xacnhan);

            bt_xacnhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(layOTP.this, Yeuto.class);
                    startActivity(intent);
                }
            });

        }
}
