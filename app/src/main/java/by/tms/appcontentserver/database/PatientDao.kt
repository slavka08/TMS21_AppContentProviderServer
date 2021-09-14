package by.tms.appcontentserver.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.tms.appcontentserver.database.PatientEntity.Companion.COLUMN_ID
import by.tms.appcontentserver.database.PatientEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPatient(): Flow<List<PatientEntity>>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllPatientsCursor(): Cursor

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(patient: PatientEntity) : Long

    @Query("DELETE FROM $TABLE_NAME" +
            " WHERE $COLUMN_ID = :id")
    suspend fun deletePatientById(id: Long)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()

}