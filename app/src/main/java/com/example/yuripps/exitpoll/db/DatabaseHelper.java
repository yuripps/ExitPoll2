package com.example.yuripps.exitpoll.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Poll.db";
    private static final int DATABASE_VERSION = 1;

    public static final String NUMBER_TABLE = "number_table";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_IMAGE = "image";
    public static final String COL_SCORE = "score";

    private static final String SQL_CREATE_TABLE_NUMBER
            = "CREATE TABLE " + NUMBER_TABLE + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT,"
            + COL_IMAGE + " TEXT,"
            + COL_SCORE + " INT"
            + ")";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //----------------------------- FOOD ---------------------------------
        db.execSQL(SQL_CREATE_TABLE_NUMBER);
        ContentValues s = new ContentValues();
        s.put(COL_NAME, "Number1");
        s.put(COL_SCORE, 0);
        s.put(COL_IMAGE, "one.png");
        db.insert(NUMBER_TABLE, null, s);

        s = new ContentValues();
        s.put(COL_NAME, "Number2");
        s.put(COL_SCORE, 0);
        s.put(COL_IMAGE, "two.png");
        db.insert(NUMBER_TABLE, null, s);


        s = new ContentValues();
        s.put(COL_NAME, "Number3");
        s.put(COL_SCORE, 0);
        s.put(COL_IMAGE, "three.png");
        db.insert(NUMBER_TABLE, null, s);


        s = new ContentValues();
        s.put(COL_NAME, "Number4");
        s.put(COL_SCORE, 0);
        s.put(COL_IMAGE, "vote_no.jpg");
        db.insert(NUMBER_TABLE, null, s);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}