package com.example.eatwut.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, "example.db", null, 4) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        // create table if not exists note(ID INT PRIMARY KEY NOT NULL,createtime TIMESTAMP NOT NULL,chagetime TIMESTAMP,title CHAR(255) NOT NULL,content TEXT NOT NULL);
        val sql = "create table if not exists $TABLE_NAME(ID INTEGER PRIMARY KEY AUTOINCREMENT,createtime TIMESTAMP NOT NULL,chagetime TIMESTAMP,title CHAR(255) NOT NULL,content TEXT NOT NULL);"
        sqLiteDatabase.execSQL(sql)
    }
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS " + TABLE_NAME
        sqLiteDatabase.execSQL(sql)
        onCreate(sqLiteDatabase)
    }
    //声明静态变量
    companion object {
        private val DB_VERSION = 1
        private val DB_NAME = "uptou.db"
        private val TABLE_NAME = "uptou"
    }

}