package by.tms.appcontentserver.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.tms.appcontentserver.R
import by.tms.appcontentserver.database.PatientEntity

class PatientViewHolder(
    itemView: View,
    private val  lInterface: ListInterface
): RecyclerView.ViewHolder(itemView) {

    private val patient: TextView = itemView.findViewById(R.id.patient)
    private val btnDelete: Button = itemView.findViewById(R.id.btnDel)

    fun bind(patientEntity: PatientEntity) {
        patient.text = patientEntity.patient

        btnDelete.setOnClickListener {
            lInterface.patientDeleteClick(patientEntity.id)
        }
    }
}