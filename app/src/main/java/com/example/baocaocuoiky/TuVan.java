package com.example.baocaocuoiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TuVan extends AppCompatActivity {
    ImageView img_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacsituvan);
        img_sms=(ImageView) findViewById(R.id.sms1);
        img_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","xin chào ....");
                intent.setData(Uri.parse("sms:01231231200"));
                startActivity(intent);
            }
        });
    }
}