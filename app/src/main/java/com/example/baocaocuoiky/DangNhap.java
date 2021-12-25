package com.example.baocaocuoiky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhap extends AppCompatActivity {
    private EditText username_login,password_login;
    private Button bt_dn;
    private DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        bt_dn = findViewById(R.id.dangnhap);
        username_login= findViewById(R.id.user_dangnhap);
        password_login= findViewById(R.id.password);
        myDb= new DataBaseHelper(this);
        loginUser();
        //bt_dn.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
        //Intent intent = new Intent(DangNhap.this, TrangChu.class);
        //startActivity(intent);
        //hello
        //}
        //});

    }
    private void loginUser(){
        bt_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = false;
                if(CheckNull.isNotNull(username_login.getText().toString(),password_login.getText().toString())){
                    var = myDb.checkUser(username_login.getText().toString(),password_login.getText().toString());
                }
                else{
                    Toast.makeText(getApplicationContext(), "Hãy nhập đầy đủ các dòng thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(var){
                    Toast.makeText(DangNhap.this, "Đăng nhập thành công!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DangNhap.this,TrangChu.class));
                    finish();

                }
                else {
                    Toast.makeText(DangNhap.this, "Đăng nhập thất bại!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}