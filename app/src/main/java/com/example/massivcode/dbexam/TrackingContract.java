package com.example.massivcode.dbexam;

import android.provider.BaseColumns;

/**
 * Created by massivCode on 2016-02-25.
 */
public class TrackingContract {

    public static class TrackingEntry implements BaseColumns {
        public static final String TABLE_NAME = "Tracking";
        public static final String COLUMN_NAME_START_TIME = "start_time";
        public static final String COLUMN_NAME_END_TIME = "end_time";
        public static final String COLUMN_NAME_MEMO = "memo";
    }
}
