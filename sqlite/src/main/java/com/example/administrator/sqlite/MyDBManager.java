package com.example.administrator.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.Timestamp;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Administrator on 2015/5/13.
 */
public class MyDBManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public MyDBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.db= this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS ClockMessage" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT,alarmTime  integer, VoiceFileRoot String,alarmMethod int,message TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE ClockMessage ADD COLUMN other STRING");
    }
    public void Insert(clockMessage cm)
    {
        db.execSQL("INSERT INTO ClockMessage VALUES(null, ?, ?, ?, ?)", new Object[]{cm.getAlarmTime(),cm.getVoiceFileRoot(),cm.getAlarmMethod(),cm.getMessage()});
    }
    public Cursor FindById(int id)
    {
        return db.rawQuery("select * from ClockMessage where _id=?", new String[]{""+id});
    }
    public Cursor FindByTime(long time)
    {
        return db.rawQuery("select * from ClockMessage where alarmTime>=?", new String[]{""+time});
    }
}
