package com.example.massivcode.dbexam;

import android.provider.BaseColumns;

/**
 * Created by massivCode on 2016-02-25.
 */
public class TrackingPathContract {

    public static class TrackingPathEntry implements BaseColumns {
        public static final String TABLE_NAME = "TrackingPath";
        public static final String COLUMN_NAME_FK = "fk";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
    }
}
