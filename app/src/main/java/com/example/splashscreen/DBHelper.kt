package com.example.splashscreen

import android.app.Dialog
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

        private var TABLE_NAME="bike"
        private var DB_BIKE_ID="bikeid"
        private var DB_BIKE_NAME="bikename"
        private var DB_BIKE_DECS="bikedescription"
        private var DB_BIKE_PRICE="bikeprice"
        private var DB_BIKE_SETCAP="setcap"
        private var DB_BIKE_FULLCAP="fullcap"


    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $DB_TABEL ($DB_SUPNAME  TEXT" +
                ",$DB_SUPUSERNAME TEXT,$DB_SUPPASSWORD PASSWORD,$DB_SUPEMAIL EMAIL,$DB_SUPMOBILENUMER LONG)"

        var bike_query="CREATE TABLE $TABLE_NAME ($DB_BIKE_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",$DB_BIKE_NAME TEXT,$DB_BIKE_DECS TEXT,$DB_BIKE_PRICE INTEGER,$DB_BIKE_SETCAP INTEGER,$DB_BIKE_FULLCAP INTEGER)"
        p0?.execSQL(query)
        p0?.execSQL(bike_query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $DB_TABEL IF EXISTS"
        var bike_query="DROP TABLE $TABLE_NAME IF EXISTS"
        p0?.execSQL(query)
        p0?.execSQL(bike_query)
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
    fun bike_insert(emp:Bike):Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_BIKE_NAME,emp.bike_name)
        cv.put(DB_BIKE_DECS,emp.bike_desc)
        cv.put(DB_BIKE_PRICE,emp.bike_price)
        cv.put(DB_BIKE_SETCAP,emp.bike_stecap)
        cv.put(DB_BIKE_FULLCAP,emp.bike_fullcap)

        var flag= db.insert(TABLE_NAME,null,cv)
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
    fun bike_retriveall():ArrayList<Bike>
    {
        var db =readableDatabase
        var cursor=db.query(TABLE_NAME,null,null,null,null,null,null)
        var arr:ArrayList<Bike> = ArrayList()
        while (cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var bikename=cursor.getString(1)
            var bikedesc=cursor.getString(2)
            var bikeprice=cursor.getInt(3)
            var bikestecap=cursor.getInt(4)
            var bikefullcap=cursor.getInt(5)
            var emp=Bike(id,bikename,bikedesc,bikeprice,bikestecap,bikefullcap)
            arr.add(emp)



        }
        return arr


    }
    fun GetAllBike() : ArrayList<Bike>
    {
        var db = readableDatabase
        var arr = ArrayList<Bike>()
        var cursor = db.query(TABLE_NAME,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var bikename=cursor.getString(1)
            var bikedesc=cursor.getString(2)
            var bikeprice=cursor.getInt(3)
            var bikestecap=cursor.getInt(4)
            var bikefullcap=cursor.getInt(5)
            var emp=Bike(id,bikename,bikedesc,bikeprice,bikestecap,bikefullcap)
            arr.add(emp)


        }
        return arr
        db.close()
    }
    fun Delete(id:Int)
    {
        var db=writableDatabase
        db.delete(TABLE_NAME,"$DB_BIKE_ID=$id",null)
        db.close()
    }

    fun retriveAll():ArrayList<Bike_updeta>
    {
        var arr=ArrayList<Bike_updeta>()
        var db=readableDatabase
        var cursor=db.query(TABLE_NAME,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {

            var id=cursor.getInt(0)
            var name=cursor.getString(1)
            var desc=cursor.getString(2)
            var p=Bike_updeta(id,name,desc)
            arr.add(p)
        }
        return arr

    }
    fun update(p:Bike_updeta)
    {
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(DB_BIKE_NAME,p.bname)
        cv.put(DB_BIKE_DECS,p.bdesc)
        var flag=db.update(
            TABLE_NAME,cv,"$DB_BIKE_ID=${p.bid}",
            null)
        db.close()
    }
    fun bike_opretion():ArrayList<Bike_opration>
    {
        var arr=ArrayList<Bike_opration>()
        var db=readableDatabase
        var cursor=db.query(TABLE_NAME,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {

            var id=cursor.getInt(0)
            var price=cursor.getInt(3)
            var p=Bike_opration(id,price)
            arr.add(p)
        }
        return arr

    }

}
