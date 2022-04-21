package com.example.simplymanage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBSupport extends SQLiteOpenHelper {
    public DBSupport(@Nullable Context context) {
        super(context, "authentication.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        //if doesnt insert, will return -1 else any other values
        long result = db.insert("users", null, contentValues);

        return result != -1;
    }

    public Boolean checkuser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[]{username} );
        return cursor.getCount() > 0;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password} );
        return cursor.getCount() > 0;
    }

}
