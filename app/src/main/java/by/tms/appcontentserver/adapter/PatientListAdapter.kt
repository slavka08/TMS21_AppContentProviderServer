package by.tms.appcontentserver.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.appcontentserver.R
import by.tms.appcontentserver.database.PatientEntity

class PatientListAdapter(
    private val lInterface: ListInterface
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listPatient: MutableList<PatientEntity> = mutableListOf()

    fun setNewList(list: List<PatientEntity>) {
        listPatient.clear()
        listPatient.addAll(list)
    }

    fun getData() = listPatient

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_patients, parent, false)
        return PatientViewHolder(view, lInterface)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PatientViewHolder).bind(listPatient[position])
    }

    override fun getItemCount(): Int = listPatient.size
}