package com.example.massivcode.dbexam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by massivCode on 2016-02-25.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Jeegy.db";
    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TRACKING =
            "CREATE TABLE IF NOT EXISTS " + TrackingContract.TrackingEntry.TABLE_NAME + " (" +
                    TrackingContract.TrackingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TrackingContract.TrackingEntry.COLUMN_NAME_START_TIME + " INTEGER NOT NULL UNIQUE, " +
                    TrackingContract.TrackingEntry.COLUMN_NAME_END_TIME + " INTEGER NOT NULL, " +
                    TrackingContract.TrackingEntry.COLUMN_NAME_MEMO + " TEXT " +
                    ");";

    private static final String SQL_CREATE_TRACKING_PATH =
            "CREATE TABLE IF NOT EXISTS " + TrackingPathContract.TrackingPathEntry.TABLE_NAME + " ( " +
                    TrackingPathContract.TrackingPathEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TrackingPathContract.TrackingPathEntry.COLUMN_NAME_FK + " INTEGER NOT NULL, " +
                    TrackingPathContract.TrackingPathEntry.COLUMN_NAME_LATITUDE + " REAL NOT NULL, " +
                    TrackingPathContract.TrackingPathEntry.COLUMN_NAME_LONGITUDE + " REAL NOT NULL, " +
                    "FOREIGN KEY(" +
                    TrackingPathContract.TrackingPathEntry.COLUMN_NAME_FK +
                    ") REFERENCES " +
                    TrackingContract.TrackingEntry.TABLE_NAME +
                    "(" +
                    TrackingContract.TrackingEntry.COLUMN_NAME_START_TIME
                    + ")"
                    + ");";

    private static DbHelper sSingleton = null;

    public static synchronized DbHelper getInstance(Context context) {
        if (sSingleton == null) {
            sSingleton = new DbHelper(context);
        }
        return sSingleton;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        db.execSQL(SQL_CREATE_TRACKING);
        db.execSQL(SQL_CREATE_TRACKING_PATH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
