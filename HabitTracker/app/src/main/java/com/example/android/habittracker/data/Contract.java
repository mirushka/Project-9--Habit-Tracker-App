package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Mirka on 03/07/2017.
 */

public class Contract {

    public static final class HabitEntry implements BaseColumns {

        //Name of the Table
        public static final String HABIT_TABLE_NAME = "habits";
        //Columns
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_ACTIVITY = "activity";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_NOTES = "notes";

    }
}
