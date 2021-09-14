package by.tms.appcontentserver.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.tms.appcontentserver.database.PatientEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PatientEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,

    @ColumnInfo(name = COLUMN_PATIENT)
    val patient: String

) {
    companion object {
        const val TABLE_NAME = "patient_table"
        const val COLUMN_ID = "id"
        const val COLUMN_PATIENT = "patient"
    }
}