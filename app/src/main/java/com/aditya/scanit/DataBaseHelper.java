package com.aditya.scanit;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Product.db";
    public static final String TABLE_NAME="History_table";
    public static final String LIST_TABLE="LIST_TABLE";
    public static final String COL_1="ID";
    public static final String COL_2="BARNUMBER";
    public static final String COL_3="COUNTRY";
    public static final String COL_4="COUNTRYIMAGE";
    public static final String COL_o1="COUNTRYNAME";
    public static final String COL_o2="COUNT";




    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,BARNUMBER TEXT,COUNTRY TEXT,COUNTRYIMAGE BLOB)");
        sqLiteDatabase.execSQL("create table "+LIST_TABLE+" (COUNTRYNAME TEXT PRIMARY KEY,COUNT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ LIST_TABLE);
        onCreate(sqLiteDatabase);
    }

        public boolean insertData(String barnumber,String country,byte[] image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,barnumber);
        contentValues.put(COL_3,country);
        contentValues.put(COL_4,image);
        long result =db.insert(TABLE_NAME,null,contentValues);
        if (result== -1){
            return false;
        }
        else
            return true;
    }
    public boolean insertList(String countryName,int count){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_o1,countryName);
        contentValues.put(COL_o2,count);
        long result=db.insert(LIST_TABLE,null,contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;
    }

    public boolean updateList(String countryName,int count){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_o1,countryName);
        contentValues.put(COL_o2,count);
        long result=db.update(LIST_TABLE,contentValues,"COUNTRYNAME = ?",new String[] {countryName});
        if (result==-1){
            return false;
        }
        else
            return true;
    }




    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
