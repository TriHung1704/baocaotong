package com.example.baocaocuoiky;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class TrangChu extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    TextView img_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_home);
        img_web=(TextView)findViewById(R.id.tt);
        recyclerView= (RecyclerView)findViewById(R.id.recview);
        dataholder= new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor= new ThongtinDatabase(this ).readalldata();
        while (cursor.moveToNext())
        {
            model obj= new model(cursor.getString(1),cursor.getString(2) ,cursor.getString(3),cursor.getString(4),cursor.getString(5));
            dataholder.add(obj);
        }
        myadapter adapter= new myadapter(dataholder);
        recyclerView.setAdapter(adapter);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent trangchu = new Intent(TrangChu.this, TrangChu.class);
                        startActivity(trangchu);
                        break;
                    case R.id.navigation_khaibao:
                        Intent khaibao = new Intent(TrangChu.this,KhaiBao.class);
                        startActivity(khaibao);
                        break;
                    case R.id.navigation_chat:
                        Intent chat = new Intent(TrangChu.this,TuVan.class);
                        startActivity(chat);
                        break;
                    case R.id.navigation_user:
                        Intent thongbao = new Intent(TrangChu.this,ThongTinCaNhan.class);
                        startActivity(thongbao);
                        break;


                }
                return true;
            }
        });
        img_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://covid19.gov.vn/"));
                startActivity(intent);
            }
        });
    };
}
