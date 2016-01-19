package com.example.myapp;

import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;

public class spichalHelper {
    DBHelper dbHelper;
    private ArrayList<spichal> contacts;


    public spichalHelper(Context context){
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
        contacts = new ArrayList<spichal>();
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery("SELECT * FROM " + DBHelper.TABLE_spichal, null);
            if (cursor.moveToFirst()){
                do {
                    spichal c = new spichal();
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


    public spichal getContact(long id){
        try {
            dbHelper.openDataBase();
            Cursor cursor = dbHelper.db.rawQuery(
                    "SELECT * FROM " + DBHelper.TABLE_spichal + " WHERE id = ? ",
                    new String[]{String.valueOf(id)});
            spichal c = new spichal();
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





    public ArrayList<spichal> getContacts(){
        return this.contacts;
    }
}
