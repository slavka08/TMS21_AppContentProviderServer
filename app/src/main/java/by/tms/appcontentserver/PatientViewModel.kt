package by.tms.appcontentserver

import androidx.lifecycle.*
import by.tms.appcontentserver.database.PatientEntity
import by.tms.appcontentserver.repository.PatientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PatientViewModel(private val repository: PatientRepository): ViewModel() {

    val allPatient: LiveData<List<PatientEntity>> = repository.getAllPatient().asLiveData()

    fun addPatient(patient: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPatient(patient)
        }
    }

    fun deletePatientById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePatientById(id)
        }
    }

    fun clearDB() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}

class PatientViewModelFactory(private val repository: PatientRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PatientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PatientViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}