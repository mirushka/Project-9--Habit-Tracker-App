package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mirka on 03/07/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    //Constants
    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();
    //Database version
    public static final int DATABASE_VERSION = 1;
    //Name od the database file
    public static final String DATABASE_NAME = "habit.db";
    private SQLiteDatabase db;

    public HabitDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create a String containing the SQL statement to create the habits table
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + Contract.HabitEntry.HABIT_TABLE_NAME + " ("
                + Contract.HabitEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Contract.HabitEntry.COLUMN_ACTIVITY + " TEXT NOT NULL, "
                + Contract.HabitEntry.COLUMN_DURATION + " INTEGER NOT NULL, "
                + Contract.HabitEntry.COLUMN_DATE + " INTEGER NOT NULL, "
                + Contract.HabitEntry.COLUMN_NOTES + " TEXT NOT NULL);";

        //Execute the SQL statement
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
    String SQL_DELETE_ENTRIES = "DELETE TABLE " + Contract.HabitEntry.HABIT_TABLE_NAME;
    sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
    onCreate(sqLiteDatabase);
    }

    public void insertData(ContentValues contentValues) {
        db = getWritableDatabase();
        db.insert(Contract.HabitEntry.HABIT_TABLE_NAME, null, contentValues);
    }

    public Cursor readData(int id){
        Cursor cursor;
        String selection = Contract.HabitEntry.COLUMN_ID + " =?";
        String[] selectionArg = new String[]{Integer.toString(id)};
        db = getReadableDatabase();
        cursor = db.query(true, Contract.HabitEntry.HABIT_TABLE_NAME, null, selection, selectionArg, null,null, null,null);
        cursor.moveToFirst();
        cursor.close();
        db.close();
        return cursor;
    }
}
