package com.example.baocaocuoiky;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ThongTinCaNhan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canhan);

        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_user);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(ThongTinCaNhan.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_khaibao:
                        Intent giohang = new Intent(ThongTinCaNhan.this,KhaiBao.class);
                        startActivity(giohang);
                        break;

                    case R.id.navigation_chat:
                        Intent chat = new Intent(ThongTinCaNhan.this,TuVan.class);
                        startActivity(chat);
                        break;

                    case R.id.navigation_user:
                        Intent thongbao = new Intent(ThongTinCaNhan.this,ThongTinCaNhan.class);
                        startActivity(thongbao);
                        break;


                }
                return true;
            }
        });

    }


}
