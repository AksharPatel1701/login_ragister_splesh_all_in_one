package com.example.splashscreen

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var context: Context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        private var DB_NAME="signup"
        private var DB_TABEL="sup"
        private var DB_VERSION=1
        private var DB_SUPNAME="name"
        private var DB_SUPUSERNAME="username"
        private var DB_SUPPASSWORD="password"
        private var DB_SUPEMAIL="email"
        private var DB_SUPMOBILENUMER="nuber"


    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $DB_TABEL ($DB_SUPNAME  TEXT" +
                ",$DB_SUPUSERNAME TEXT,$DB_SUPPASSWORD PASSWORD,$DB_SUPEMAIL EMAIL,$DB_SUPMOBILENUMER LONG)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $DB_TABEL IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)

    }
    fun insert(emp:Sup):Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_SUPNAME,emp.sup_name)
        cv.put(DB_SUPUSERNAME,emp.sup_username)
        cv.put(DB_SUPPASSWORD,emp.sup_pass)
        cv.put(DB_SUPEMAIL,emp.sup_emil)
        cv.put(DB_SUPMOBILENUMER,emp.sup_numb)
        var flag= db.insert(DB_TABEL,null,cv)
        if (flag>0)
        {
            return true
        }
        else
        {
            return false
        }
    }
    fun retriveall():ArrayList<Sup>
    {
        var db =readableDatabase
        var cursor=db.query(DB_TABEL,null,null,null,null,null,null)
        var arr:ArrayList<Sup> = ArrayList()
        while (cursor.moveToNext())
        {

            var username=cursor.getString(1)
            var password=cursor.getString(2)



            var emp=Sup(username,password)
            arr.add(emp)



        }
        return arr


    }

}