package com.example.waleed.buttongame;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "ButtonGame2";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context)
    {

        super(context,DBNAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE High_chart (score INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int i2) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS High_chart");

        onCreate(sqLiteDatabase);
    }
}