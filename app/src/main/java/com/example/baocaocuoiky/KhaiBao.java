package com.example.baocaocuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class KhaiBao extends AppCompatActivity {
    Button bt_tieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan);
        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_khaibao);
        bt_tieptuc = findViewById(R.id.tieptuc);

        bt_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KhaiBao.this, KhaoSatbenh.class);
                startActivity(intent);
            }
        });
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(KhaiBao.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_khaibao:
                        Intent giohang = new Intent(KhaiBao.this,KhaiBao.class);
                        startActivity(giohang);
                        break;

                    case R.id.navigation_chat:
                        Intent chat = new Intent(KhaiBao.this,TuVan.class);
                        startActivity(chat);
                        break;

                    case R.id.navigation_user:
                        Intent thongbao = new Intent(KhaiBao.this,ThongTinCaNhan.class);
                        startActivity(thongbao);
                        break;


                }
                return true;
            }
        });

    };
}
