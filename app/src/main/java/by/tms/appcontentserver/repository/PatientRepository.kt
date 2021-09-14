package by.tms.appcontentserver.repository

import by.tms.appcontentserver.database.PatientDao
import by.tms.appcontentserver.database.PatientEntity

class PatientRepository(private val patientDao: PatientDao) {

    //вернет всех patient из БД
    fun getAllPatient() = patientDao.getAllPatient()

    //вернет Cursor, это нужно для работы ContentProvider
    fun getAllPatientsCursor() = patientDao.getAllPatientsCursor()

    //добавит patient в БД
    suspend fun addPatient(string: String): Long {
        return patientDao.insert(
            PatientEntity(id =0, patient = string)
        )
    }

    //удалит patient из БД по его id
    suspend fun deletePatientById(id: Long) = patientDao.deletePatientById(id)

    //очистит БД
    suspend fun deleteAll() = patientDao.deleteAll()
}