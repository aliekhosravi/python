package com.example.myapp;

import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;

public class cityHelper {
    DBHelper dbHelper;

    public cityHelper(Context context){
        dbHelper = new DBHelper(context);
    }


    public ArrayList<city> getAll(Long id_province){
        ArrayList<city> city = new ArrayList<city>();
        try {
            String sql = "SELECT * FROM " + DBHelper.TABLE_city;
            String[] params = null;
            if (id_province != null){
                sql += " WHERE province_id = ? ";
                params = new String[]{String.valueOf(id_province)};
            }
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery(sql, params);
            if (cursor.moveToFirst()){
                do {
                    city p = new city();
                    p.id = cursor.getLong(cursor.getColumnIndex("id"));
                    p.id_province = cursor.getLong(cursor.getColumnIndex("id_province"));
                    p.name = cursor.getString(cursor.getColumnIndex("name"));
                    city.add(p);
                } while (cursor.moveToNext());
            }
            dbHelper.closeDatabase();
            return city;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
