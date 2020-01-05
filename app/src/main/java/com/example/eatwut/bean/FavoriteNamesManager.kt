package com.example.eatwut.bean

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.eatwut.dataBase.DbHelper

class NoteManager(contxt: Context){
    val db: SQLiteDatabase
    init {
        db= DbHelper(contxt).writableDatabase
    }

    /**
     * 添加一条笔记
     */
    fun addNote(title:String,content:String){
        var nowtime=System.currentTimeMillis()
        var sql="insert into note (createtime, chagetime, title,content) values ($nowtime,$nowtime,'$title','$content')"
        db.execSQL(sql)
    }

    /**
     * 删除一条笔记
     */
    fun deleteNote(id:Int){
        var sql="delete from note where ID=$id"
        db.execSQL(sql)
    }

    /**
     * 修改一条笔记
     */
    fun chageNote(id:Int,title: String,content: String){
        var nowtime=System.currentTimeMillis()
        var sql="update note set title='$title',content='$content',chagetime='$nowtime' where ID=$id"
        db.execSQL(sql)
    }

    /**
     * 查询笔记
     */
    fun queryNote(id: Int): FavoriteNamesBean {
        val bean= FavoriteNamesBean()
        var sql="select * from note where ID=$id"
        var cursor=db.rawQuery(sql,null) //执行查询语句
        if (cursor.moveToNext()){
            bean.id=cursor.getInt(0)
            bean.name=cursor.getString(1)
            bean.level=cursor.getLong(2)

        }
        return bean
    }

    /**
     * 查询所有笔记
     */
    fun queryNotes():ArrayList<FavoriteNamesBean>{
        val list: ArrayList<FavoriteNamesBean> = arrayListOf()//创建集合
        var sql="select * from note" //构建查询语句
        var cursor=db.rawQuery(sql,null) //执行查询语句
        while (cursor.moveToNext()){ //设置循环语句
            val bean= FavoriteNamesBean()
            bean.id=cursor.getInt(0) //获取id
            bean.name=cursor.getString(1)
            bean.level=cursor.getLong(2)
            list.add(bean) //添加一条笔记到集合
        }
        return list
    }
}