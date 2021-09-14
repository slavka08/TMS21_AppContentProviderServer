package by.tms.appcontentserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.appcontentserver.adapter.ListInterface
import by.tms.appcontentserver.adapter.PatientListAdapter
import by.tms.appcontentserver.databinding.ActivityMainBinding
import androidx.recyclerview.widget.DiffUtil
import by.tms.appcontentserver.adapter.PatientDiffUtil

class MainActivity : AppCompatActivity(), ListInterface {

    private lateinit var binding: ActivityMainBinding

    private val patientViewModel: PatientViewModel by viewModels {
        PatientViewModelFactory((application as PatientsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //передаем адаптер и LayoutManager в RecyclerView
        binding.patientList.apply {
            adapter = PatientListAdapter(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        //передача данных через DiffUtil
        patientViewModel.allPatient.observe(this) {
            val adapter = binding.patientList.adapter as PatientListAdapter
            val diffCallback = PatientDiffUtil(it, adapter.getData())
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            adapter.setNewList(it)
            diffResult.dispatchUpdatesTo(adapter)
            binding.patientList.smoothScrollToPosition(it.size)
        }

        //сохранение в БД
        binding.btnAdd.setOnClickListener {
            if (binding.patientInput.text.toString().isNotEmpty()) {
                patientViewModel.addPatient(binding.patientInput.text.toString())
                //binding.patientInput.setText(String.EMPTY)
            } else {
                Toast.makeText(this, getString(R.string.toast_empty_patient), Toast.LENGTH_LONG).show()
            }
        }

        //очищаем полностью БД
        binding.btnClear.setOnClickListener {
            patientViewModel.clearDB()
        }
    }

    override fun patientDeleteClick(id: Long) {
        patientViewModel.deletePatientById(id)
    }


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rs = contentResolver.query(CONTENT_URI, arrayOf(_id,INFO,IMAGE),null,null)
        if (rs?.moveToFirst() == true) {
            Toast.makeText(this, rs.getString(0) +"/"+rs.getString(1)+"/"+rs.getString(2), Toast.LENGTH_SHORT).show()
        }

        val z =1
        *//*       val helper = MyHelper(this)
            val db = helper.readableDatabase
            var rw = db.rawQuery("SELECT * FROM TMSdb",null)
            if (rw.moveToFirst()) {
                  }*//*
    }*/
}