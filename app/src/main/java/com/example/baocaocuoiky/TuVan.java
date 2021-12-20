package com.example.baocaocuoiky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TuVan extends AppCompatActivity {
    ImageView img_sms1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bacsituvan);
        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_chat);
        img_sms1=(ImageView) findViewById(R.id.sms1);
        img_sms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","xin chào ....");
                intent.setData(Uri.parse("sms:01231231200"));
                startActivity(intent);
            }
        });
        img_sms1=(ImageView) findViewById(R.id.sms2);
        img_sms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","xin chào ....");
                intent.setData(Uri.parse("sms:0836336639"));
                startActivity(intent);
            }
        });
        img_sms1=(ImageView) findViewById(R.id.sms3);
        img_sms1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","xin chào ....");
                intent.setData(Uri.parse("sms:0346982236"));
                startActivity(intent);
            }
        });
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(TuVan.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_khaibao:
                        Intent giohang = new Intent(TuVan.this,KhaiBao.class);
                        startActivity(giohang);
                        break;

                    case R.id.navigation_chat:
                        Intent chat = new Intent(TuVan.this,TuVan.class);
                        startActivity(chat);
                        break;

                    case R.id.navigation_user:
                        Intent thongbao = new Intent(TuVan.this,ThongTinCaNhan.class);
                        startActivity(thongbao);
                        break;


                }
                return true;
            }
        });
    }
}