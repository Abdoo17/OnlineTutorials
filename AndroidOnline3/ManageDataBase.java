package com.example.hussienalrubaye.androidsqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

/**
 * Created by hussienalrubaye on 3/17/16.
 */
public class ManageDataBase {

    // define the reader of db
    private SQLiteDatabase db;
    Context context;
    //create new instance
    ManageDataBase( Context context){
        this.context=context;
        // create the database if it isnot created
        DatabaseHelper dbHelper = new DatabaseHelper(context);
  // start writing and reading to the database
        db = dbHelper.getWritableDatabase();
    }

    /*
    add method , add new
    user name hussein
    and age 26
    to the dtabase
    */
    public void insert()
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.NAME, "hussein");
        values.put(DatabaseHelper.Age, "26");
        long rowID = db.insert(DatabaseHelper.STUDENTS_TABLE_NAME, "", values);

        if (rowID > 0)
            Toast.makeText(context,"data is added",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"data is not added",Toast.LENGTH_LONG).show();

    }

    /*
     select all uses
     who age in range 20,27,30

       */
    public void query()
    {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DatabaseHelper.STUDENTS_TABLE_NAME);
        String[] projection = new String[] { "_id", "name", "age" };
        String selection = " age in(?, ?, ?)";
        String selectionArgs[] = new String[]{"20","27","30"};
        Cursor c = qb.query(db,	projection,	selection, selectionArgs,null, null, "name");
        if (c.moveToFirst()) {
            do{
                // load the record name and age and id
                Toast.makeText(context,
                        c.getString(c.getColumnIndex(DatabaseHelper._ID)) +
                                ", " +  c.getString(c.getColumnIndex( DatabaseHelper.NAME)) +
                                ", " + c.getString(c.getColumnIndex( DatabaseHelper.Age)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }

    /*
       delete use who age is 20 and name start with hu and follow by any string
       */
    public void delete( )
    {
        int rowID = 0;
        String selection = " name like ? and age=?";
        String selectionArgs[] = new String[]{"hu%","20"};
        rowID = db.delete(DatabaseHelper.STUDENTS_TABLE_NAME, selection, selectionArgs);

        if (rowID > 0)
            Toast.makeText(context,"data is deleted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"data is not deleted",Toast.LENGTH_LONG).show();
    }

    /*
      update use info who has id=1
       */
    public void update( )
    {
        int rowID = 0;
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.NAME, "hussein alrubaye");
        values.put(DatabaseHelper.Age, "26");
        String selection = " id=?";
        String selectionArgs[] = new String[]{"1"};
        rowID = db.update(DatabaseHelper.STUDENTS_TABLE_NAME, values, selection, selectionArgs);

            if (rowID > 0)
                Toast.makeText(context,"data is deleted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"data is not deleted",Toast.LENGTH_LONG).show();
    }
}