package com.example.ryanw.workoutlog20;

import android.provider.BaseColumns;

/**
 * Database TableData.
 * Created by ryanw on 3/25/2016.
 */
public class TableData
{
    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_NAME = "user_name";
        public static final String HEIGHT = "height";
        public static final String WEIGHT = "weight";
        public static final String AGE = "age";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_ingo";
    }
}
