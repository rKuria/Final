package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_ID = "ID";

    public DbHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    //this is called the first time a database is accessed, should have a code to create a new dabatase
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " +
                COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT )";

        db.execSQL(createTableStatement);

    }

    @Override
    //this is for new versions, compatibility
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(UserModel userModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_NAME, userModel.getName());
        cv.put(COLUMN_USER_EMAIL, userModel.getEmail());
        cv.put(COLUMN_USER_PASSWORD, userModel.getPassword());

        long insert = db.insert(USER_TABLE, null , cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }


    }
}
