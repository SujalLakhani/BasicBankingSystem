package com.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.Perameters.Perameters;
import com.Persons.Person;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(Context context) {
        super(context, Perameters.DB_NAME, null,Perameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ Perameters.TABLE_NAME + "("+Perameters.KEY_EMAIL+" TEXT PRIMARY KEY, "+Perameters.KEY_NAME+" TEXT, "+Perameters.KEY_AMOUNT+" INTEGER)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addPerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Perameters.KEY_EMAIL,person.getEmail());
        values.put(Perameters.KEY_NAME,person.getName());
        values.put(Perameters.KEY_AMOUNT,person.getAmount());
        db.insert(Perameters.TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Person> getAllPersons(){
        ArrayList<Person> personList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM "+Perameters.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        if(cursor.moveToFirst()) {
            do {
                Person person = new Person();

                //person.setId(Integer.parseInt(cursor.getString(0)));
                person.setEmail(cursor.getString(0));
                person.setName(cursor.getString(1));
                person.setAmount(cursor.getInt(2));
                personList.add(person);
            } while (cursor.moveToNext());
        }

        return personList;
    }

    public int updatePerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(Perameters.KEY_EMAIL,person.getEmail());
        values.put(Perameters.KEY_NAME,person.getName());
        values.put(Perameters.KEY_AMOUNT,person.getAmount());
        return db.update(Perameters.TABLE_NAME, values, Perameters.KEY_EMAIL + "=?", new String[]{person.getEmail()});
    }
}
