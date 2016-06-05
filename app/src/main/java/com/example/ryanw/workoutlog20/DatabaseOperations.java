package com.example.ryanw.workoutlog20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.util.Log;

/**
 * Created by ryanw on 3/25/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper
{
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME+ " (" + TableData.TableInfo.USER_NAME + " TEXT,"
            + TableData.TableInfo.HEIGHT + " TEXT," + TableData.TableInfo.AGE + " INTEGER,"
                + TableData.TableInfo.WEIGHT + " REAL);";

    public DatabaseOperations(Context context)
    {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database created");
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations dop, User user) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        if (user != null) {
            cv.put(TableData.TableInfo.USER_NAME, user.getName());
            cv.put(TableData.TableInfo.AGE, user.getAge());
            cv.put(TableData.TableInfo.HEIGHT, user.getHeight());
            cv.put(TableData.TableInfo.WEIGHT, user.getWeight());
            long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
            Log.d("Database operations", "One row inserted");
        }
    }

    public Cursor getData(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String [] columns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.HEIGHT,
                TableData.TableInfo.WEIGHT, TableData.TableInfo.AGE};
        Cursor cr = SQ.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cr;
    }
}
