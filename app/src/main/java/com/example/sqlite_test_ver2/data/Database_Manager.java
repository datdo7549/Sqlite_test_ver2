package com.example.sqlite_test_ver2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlite_test_ver2.model.Student;

import java.util.ArrayList;

public class Database_Manager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student_mn_ver2";
    public static final String TABLE_NAME="student";
    public static final String ID="id";
    public static final String NAME="name";
    public static final String EMAIL="email";
    public static final String ADDRESS="address";
    public static final String PHONE="phone";
    private Context context;
    private static int VERSION=1;
    private String SQL_QUERY="create table "+TABLE_NAME+" ("
            +ID+" integer primary key, "
            +NAME+" text, "
            +EMAIL+" text, "
            +ADDRESS+" text, "
            +PHONE+" text)";

    //Create Database:
    public Database_Manager(Context context){
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
    }

    //Create Table:
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    //Add one student to table of Database:
    public void addStudent(Student student)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,student.getmName());
        contentValues.put(EMAIL,student.getmEmail());
        contentValues.put(ADDRESS,student.getmAddress());
        contentValues.put(PHONE,student.getmPhone());
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }
    public ArrayList<Student> readAllStudent()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ArrayList<Student> temp=new ArrayList<>();
        String SQL_READ="select * from "+TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(SQL_READ,null);
        if(cursor.moveToFirst())
        {
            do {
                Student student=new Student();
                student.setmId(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmEmail(cursor.getString(2));
                student.setmAddress(cursor.getString(3));
                student.setmPhone(cursor.getString(4));
                temp.add(student);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return temp;
    }
}
