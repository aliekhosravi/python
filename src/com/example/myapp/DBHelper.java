package com.example.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.*;
import java.sql.SQLException;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "doctor.db";
    public static final String TABLE_CONTACT = "province";
    public static final String TABLE_city = "city";
    public static final String TABLE_spichal = "spichal";
    protected SQLiteDatabase db;

    private String DB_PATH;
    private final Context myContext;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        this.DB_PATH = context.getFilesDir().getPath() + "/";
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
            Log.i("database", "----- database already exists");
            File dir = new File(DB_PATH);
            boolean result = Tools.deleteDir(dir);
            Log.i("database deletion", result ? "----- previous database deleted" : "----- previous database deletion failed");
        }
        //By calling this method and empty database will be created into the default system path
        //of your application so we are gonna be able to overwrite that database with our database.
        this.getReadableDatabase();
        try {
            copyDataBase();
        } catch (IOException e) {
            Log.e("create_database", "----" + e.getMessage());
            throw new Error("Error copying database");
        }
    }

    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {
            //database doesn't exist yet.
        }

        if (checkDB != null) {
            checkDB.close();
        }

        return checkDB != null;
    }

    private void copyDataBase() throws IOException {

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

        //create path if not exists and open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(DB_PATH + DATABASE_NAME);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Log.i("database", "---- database opened");
    }

    public void closeDatabase() throws SQLException {
        this.close();
        Log.i("database", "---- database closed");
    }

    @Override
    public synchronized void close() {
        if (db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // This method is just implemented because we are extending abstract SQLiteOpenHelper
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This method is just implemented because we are extending abstract SQLiteOpenHelper
    }

}
