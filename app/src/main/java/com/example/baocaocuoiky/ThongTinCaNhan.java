package com.example.baocaocuoiky;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ThongTinCaNhan extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    myadapter myadapter;
    private model model;
    EditText search_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canhan);
        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_user);
        recyclerView= (RecyclerView)findViewById(R.id.recview);
        dataholder= new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor= new ThongtinDatabase(this ).readalldata();
        while (cursor.moveToNext())
        {
            model obj= new model(cursor.getString(1),cursor.getString(2) ,cursor.getString(3),cursor.getString(4),cursor.getString(5));
            dataholder.add(obj);
        }
        search_box = findViewById(R.id.edit_timkiem);
        search_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
        myadapter adapter= new myadapter(dataholder);
        recyclerView.setAdapter(adapter);
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
    private void filter(String text) {
        ArrayList<model> userdomains = new ArrayList<>();
        for (model u : dataholder){
            if (u.getHoten().toLowerCase().contains(text.toLowerCase())){
                userdomains.add(u);
            }
        }
        myadapter.filterList(userdomains,model);
    }


}
