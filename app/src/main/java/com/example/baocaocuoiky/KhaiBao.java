package com.example.baocaocuoiky;

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

public class KhaiBao extends AppCompatActivity {
    private EditText edquoctich,edhoten,edngaysinh,edemail,edsdt;
    private Button  bttieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan);
        BottomNavigationView bt  = findViewById(R.id.botton_navigation);
        bt.setSelectedItemId(R.id.navigation_khaibao);
        bttieptuc = findViewById(R.id.tieptuc);
        edquoctich = findViewById(R.id.quoctich);
        edhoten = findViewById(R.id.hoten);
        edngaysinh = findViewById(R.id.ngaysinh);
        edemail = findViewById(R.id.email);
        edsdt = findViewById(R.id.sdt);
        bttieptuc= findViewById(R.id.tieptuc);
        bttieptuc.setOnClickListener((view )->  {
            processinsert(edquoctich.getText().toString(),edhoten.getText().toString(),edngaysinh.getText().toString(),edsdt.getText().toString(),edemail.getText().toString());
            startActivity(new Intent(KhaiBao.this,KhaoSatbenh.class));
            finish();
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


    }
    private void processinsert(String qt, String ht, String ns, String sdt, String e) {
        String res= new ThongtinDatabase(this ).addrecode(qt,ht,ns,sdt,e);
        edquoctich.setText("");
        edhoten.setText("");
        edngaysinh.setText("");
        edsdt.setText("");
        edemail.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();


    }

    ;
}

