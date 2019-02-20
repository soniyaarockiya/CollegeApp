package com.example.a91user.collegeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";//single database name
    public static final String TABLE_NAME = "registerUSER";// first table
    public static final String Concession = "concession";// second table

    public static final String COL_1 = "ID"; // common column id
    public static final String COL_2 = "username";//table 1 element -
    public static final String COL_3 = "password";//table 1 element

    public static final String TicketType= "TicketType";//table 2-concession elemnt
    public static final String TicketClass= "TicketClass";// table 2-concession element

    





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, PASSWORD TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE Concession (ID INTEGER PRIMARY KEY AUTOINCREMENT, TicketType TEXT, TicketClass TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);//drop table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Concession);

        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }

    public boolean Checkuser(String username, String password) {

        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " AND "  + COL_3 + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;

    }

    public long ConcessionForm(String Tclass, String Ttype){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ticketClass",Tclass);
        contentValues.put("ticketType",Ttype );
        long res = db.insert("concession", null, contentValues);
        db.close();
        return res;
    }

}
