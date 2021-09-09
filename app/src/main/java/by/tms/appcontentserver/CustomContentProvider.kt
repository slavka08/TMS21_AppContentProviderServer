package by.tms.appcontentserver

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.core.content.ContentProviderCompat

class CustomContentProvider: ContentProvider() {

    companion object{
        val PROVIDER_NAME = "by.tms.appcontentserver.CustomContentProvider"
        val URL = "content://$PROVIDER_NAME/TMSdb"
        val CONTENT_URI = Uri.parse(URL)

        val _id = "_id"
        val INFO = "INFO"
        val IMAGE = "IMAGE"
    }

    private var db : SQLiteDatabase? = null
    override fun onCreate(): Boolean {
     context?.let {
        db = MyHelper(it).readableDatabase
     }
        return (db != null)
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return db?.query("TMSdb",projection,selection,selectionArgs,null,null,sortOrder)
    }

    override fun getType(uri: Uri): String? {
      return  "vnd.android.cursor.item/$URL"
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}