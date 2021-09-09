package by.tms.appcontentserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.tms.appcontentserver.CustomContentProvider.Companion.CONTENT_URI
import by.tms.appcontentserver.CustomContentProvider.Companion.IMAGE
import by.tms.appcontentserver.CustomContentProvider.Companion.INFO
import by.tms.appcontentserver.CustomContentProvider.Companion._id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rs = contentResolver.query(CONTENT_URI, arrayOf(_id,INFO,IMAGE),null,null)
        if (rs?.moveToFirst() == true) {
            Toast.makeText(this, rs.getString(0) +"/"+rs.getString(1)+"/"+rs.getString(2), Toast.LENGTH_SHORT).show()
        }

        val z =1
        /*       val helper = MyHelper(this)
            val db = helper.readableDatabase
            var rw = db.rawQuery("SELECT * FROM TMSdb",null)
            if (rw.moveToFirst()) {
                  }*/
    }
}