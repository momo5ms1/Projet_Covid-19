package com.mdw31g4.covimeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public database( Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user (fname text , lname text , phone text , gouv text , region text ,mail text primary key ,pass text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user ");

    }
    //inserting in data base
    public boolean insert(String fname, String lname ,String phone , String gouv ,String region ,String mail ,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = getContentValues();
        contentValues.put("first name",fname);
        contentValues.put("last name",lname);
        contentValues.put("phone",phone);
        contentValues.put("gouvernorat",gouv);
        contentValues.put("region",region);
        contentValues.put("email",mail);
        contentValues.put("password",pass);
        long ins = db.insert("user",null,contentValues);
        if (ins==1) return false;
        else return true;
    }

    private ContentValues getContentValues() {
        return new ContentValues();
    }

    //verification d'email
    public Boolean chkemail (String mail){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where mail=?",new String[]{mail});
        if (cursor.getCount()>0) return false;
        else return true ;

    }


}
