package com.example.se7en.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by se7en on 2016/1/29.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String BOOK_CREATE = "create table Book (" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)";

    private static final String CATEGORY_CREATE = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)";


    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BOOK_CREATE);
        db.execSQL(CATEGORY_CREATE);
    }

    /**
     * 数据库更新的最佳实践
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1:
                db.execSQL(CATEGORY_CREATE);
            case 2:
                db.execSQL("alter talbe Book add column category_id integer");
            default:
        }
    }
}
