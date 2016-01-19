package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;

public class provinceHelper {
    DBHelper dbHelper;
    private ArrayList<province> contacts;
    private ArrayList<city> cities;

    public provinceHelper(Context context){
        dbHelper = new DBHelper(context);
    }

  //  public long save(province contact){
    //    ContentValues contentValues = new ContentValues();
      //  contentValues.put("name", contact.name);

        //try {
          //  dbHelper.openDataBase();
            //long i = dbHelper.db.insert(DBHelper.TABLE_CONTACT, null, contentValues);
            //dbHelper.closeDatabase();
            //return i;
        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
        //return -1;
    //}

    public int getAll(){
        contacts = new ArrayList<province>();
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery("SELECT * FROM " + DBHelper.TABLE_CONTACT, null);
            if (cursor.moveToFirst()){
                do {
                    province c = new province();
                    c.id = cursor.getLong(cursor.getColumnIndex("id"));
                    c.name = cursor.getString(cursor.getColumnIndex("name"));
                    contacts.add(c);
                } while (cursor.moveToNext());
            }
            dbHelper.closeDatabase();
            return contacts.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts.size();
    }


    public province getContact(long id){
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery(
                    "SELECT * FROM " + DBHelper.TABLE_CONTACT + " WHERE id = ? ",
                    new String[]{String.valueOf(id)});
            province c = new province();
            if (cursor.moveToFirst()){
                c.id = cursor.getLong(cursor.getColumnIndex("id"));
                c.name = cursor.getString(cursor.getColumnIndex("name"));
            }
            dbHelper.closeDatabase();
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int getAllcity(){
        cities = new ArrayList<city>();
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery("SELECT * FROM " + DBHelper.TABLE_city, null);
            if (cursor.moveToFirst()){
                do {
                    city c = new city();
                    c.id = cursor.getLong(cursor.getColumnIndex("id"));
                    c.name = cursor.getString(cursor.getColumnIndex("name"));
                    c.id_province = cursor.getLong(cursor.getColumnIndex("id_province"));
                    cities.add(c);
                } while (cursor.moveToNext());
            }
            dbHelper.closeDatabase();
            return cities.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities.size();
    }

    public ArrayList<city> getCity(long id){
        try {
            dbHelper.openDataBase();
            ArrayList<city> citys = new ArrayList<city>();
            Cursor cursor = dbHelper.db.rawQuery(
                    "SELECT * FROM " + DBHelper.TABLE_city + " WHERE id_province = ? ",
                    new String[]{String.valueOf(id)});

            if (cursor.moveToFirst()){
                do {
                    city s = new city();
                    s.id = cursor.getLong(cursor.getColumnIndex("id"));
                    s.name = cursor.getString(cursor.getColumnIndex("name"));
                    s.id_province = cursor.getLong(cursor.getColumnIndex("id_province"));
                    citys.add(s);
                } while (cursor.moveToNext());
            }

            dbHelper.closeDatabase();
            return citys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public city getCity2(long id){
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery(
                    "SELECT * FROM " + DBHelper.TABLE_city + " WHERE id_province = ? ",
                    new String[]{String.valueOf(id)});
            city c = new city();
            if (cursor.moveToFirst()){
                c.id = cursor.getLong(cursor.getColumnIndex("id"));
                c.name = cursor.getString(cursor.getColumnIndex("name"));
            }
            dbHelper.closeDatabase();
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<city> getCities(){
        return this.cities;
    }
    public ArrayList<province> getContacts(){
        return this.contacts;
    }
}
