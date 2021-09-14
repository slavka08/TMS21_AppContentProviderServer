package by.tms.appcontentserver.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import by.tms.appcontentserver.MyHelper
import by.tms.appcontentserver.PatientsApplication

class CustomContentProvider : ContentProvider() {

    companion object {
        val PROVIDER_NAME = "by.tms.appcontentserver.provider.CustomContentProvider"
        private const val CODE_DIR = 1
        /*val URL = "content://$PROVIDER_NAME/TMSdb"
        val CONTENT_URI = Uri.parse(URL)*/

       /* val _id = "_id"
        val INFO = "INFO"
        val IMAGE = "IMAGE"*/
    }

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI(PROVIDER_NAME, "/*", CODE_DIR)
    }

    //private var db: SQLiteDatabase? = null

    override fun onCreate(): Boolean {
        return true
        /*context?.let {
            db = MyHelper(it).readableDatabase
        }
        return (db != null)*/
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val context = context ?: return null
        if (uriMatcher.match(uri) == CODE_DIR) {
            val repo = (context.applicationContext as PatientsApplication).repository
            val cursor: Cursor = repo.getAllPatientsCursor()
            cursor.setNotificationUri(context.contentResolver, uri)
            return cursor
        }

        return null
        //return db?.query("TMSdb", projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.item/$PROVIDER_NAME"
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0
}