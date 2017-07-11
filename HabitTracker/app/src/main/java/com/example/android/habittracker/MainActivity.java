package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittracker.data.Contract;
import com.example.android.habittracker.data.HabitDbHelper;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        ContentValues values = new ContentValues();
        values.put(Contract.HabitEntry.COLUMN_ACTIVITY, "Programming");
        values.put(Contract.HabitEntry.COLUMN_DURATION, 30);
        values.put(Contract.HabitEntry.COLUMN_DATE, "5/05/2017");
        values.put(Contract.HabitEntry.COLUMN_NOTES, "SQLite");
        habitDbHelper.insertData(values);

        //Insertion check
        Cursor cursor = habitDbHelper.readData(1);
        Log.v("MainActivity", cursor.toString());
    }
}

