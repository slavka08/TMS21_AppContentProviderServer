package by.tms.appcontentserver.adapter

import androidx.recyclerview.widget.DiffUtil
import by.tms.appcontentserver.database.PatientEntity

class PatientDiffUtil(
    private var newList: List<PatientEntity>,
    private var oldList: List<PatientEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean = oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean = oldList[oldItemPosition].patient == newList[newItemPosition].patient

}