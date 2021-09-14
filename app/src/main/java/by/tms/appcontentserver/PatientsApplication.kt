package by.tms.appcontentserver

import android.app.Application
import by.tms.appcontentserver.database.PatientDatabase
import by.tms.appcontentserver.repository.PatientRepository

class PatientsApplication: Application() {

    val database by lazy { PatientDatabase.getDatabase(this) }
    val repository by lazy { PatientRepository(database.patientDao()) }
}