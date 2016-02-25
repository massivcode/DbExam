package com.example.massivcode.dbexam;

import android.content.Context;

/**
 * Created by massivCode on 2016-02-25.
 */
public class DbUtil {

    private DbHelper mHelper;
    private Context mContext;

    public DbUtil(Context context) {
        mHelper = DbHelper.getInstance(context);
        mContext = context;
    }

}
