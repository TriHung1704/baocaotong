package com.example.baocaocuoiky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ThongtinDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="INFORMATION";


    public ThongtinDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry="create table tbl_thongtin (id integer primary key autoincrement, quoctich text,hoten text,ngaysinh text,sdt text,email text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry="DROP TABLE IF EXISTS tbl_thongtin";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);

    }
    public String addrecode(String quoctich,String hoten,String ngaysinh,String sdt,String email){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("quoctich",quoctich);
        cv.put("hoten",hoten);
        cv.put("ngaysinh",ngaysinh);
        cv.put("sdt",sdt);
        cv.put("email",email);
       float res= db.insert("tbl_thongtin",null,cv);
       if(res== -1)
           return "Thêm thất bại";


       else
           return "Thêm Thành Công";

    }
    public Cursor readalldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        String qry="select * from tbl_thongtin order by id desc";
        Cursor cursor= db.rawQuery(qry,null);
        return cursor;

    }
}
