package by.tms.appcontentserver

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context, "TMSdb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TMSdb(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, INFO TEXT, IMAGE TEXT )")
        db?.execSQL("INSERT INTO TMSdb(NAME,INFO,IMAGE)  VALUES('test1 name','test1 info','https://www.meme-arsenal.com/memes/b5b6a757d1bd204196272992a74ebec3.jpg')")
        db?.execSQL("INSERT INTO TMSdb(NAME,INFO,IMAGE)  VALUES('test2 name','test2 info','https://www.meme-arsenal.com/memes/b5b6a757d1bd204196272992a74ebec3.jpg')")
        db?.execSQL("INSERT INTO TMSdb(NAME,INFO,IMAGE)  VALUES('test3 name','test3 info','https://www.meme-arsenal.com/memes/b5b6a757d1bd204196272992a74ebec3.jpg')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}