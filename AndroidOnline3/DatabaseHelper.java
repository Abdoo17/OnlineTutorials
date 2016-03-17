package com.example.hussienalrubaye.androidsqllite;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hussienalrubaye on 3/17/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String Age = "age";

    static final String DATABASE_NAME = "College";
    static final String STUDENTS_TABLE_NAME = "students";
    static final int DATABASE_VERSION = 1;
    //script for create table
    static final String CREATE_DB_TABLE =
            " CREATE TABLE IF NOT EXISTS " + STUDENTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " age TEXT NOT NULL);";



        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        { //create the table for only first time
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +  STUDENTS_TABLE_NAME);
            onCreate(db);
        }

}
