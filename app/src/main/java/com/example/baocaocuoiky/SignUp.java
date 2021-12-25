package com.example.baocaocuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
        private EditText usernamedk,emaildk,passworddk;
        private Button  btndangky;
        private DataBaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emaildk = findViewById(R.id.edemail);
        usernamedk  = findViewById(R.id.edsdt);
        passworddk = findViewById(R.id.edpassword);
        btndangky = findViewById(R.id.btndk);
        myDB = new DataBaseHelper(this );
        insertUser();
    }
    private void insertUser(){
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = false;

                if(CheckNull.isNotNull(usernamedk.getText().toString(),emaildk.getText().toString(),passworddk.getText().toString())){
                    var = myDB.registerUser(usernamedk.getText().toString(),emaildk.getText().toString(),passworddk.getText().toString());

                }
                else{
                    Toast.makeText(getApplicationContext(), "Hãy nhập đầy đủ các dòng thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(var){
                    Toast.makeText(SignUp.this, "Đăng kí thành công!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this, Home.class));
                }
                else{
                    Toast.makeText(SignUp.this, "Đăng kí thất bại!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}