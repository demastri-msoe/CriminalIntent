package com.msoe.bnrtextapps.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.msoe.bnrtextapps.criminalintent.databinding.ListItemCrimeBinding
import com.msoe.bnrtextapps.criminalintent.databinding.ListItemCrimePoliceRequiredBinding

open class CrimeHolderBase (
    internal val binding: ViewBinding
    // once this class maintains the bindings (see below), this can be private
) : RecyclerView.ViewHolder(binding.root) {
    open fun bind(crime: Crime) {
        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeHolder(
    val thisbinding:ViewBinding
    // once this class maintains the bindings (see below), this can be private
) : CrimeHolderBase(thisbinding) {
    override fun bind(crime: Crime) {
        super.bind(crime)
        var baseBinding: ListItemCrimeBinding = binding as ListItemCrimeBinding
        baseBinding.crimeTitle.text = crime.title
        baseBinding.crimeDate.text = crime.date.toString()
    }
}

class CrimeHolderPolice(
    val thisbinding: ViewBinding
    // once this class maintains the bindings (see below), this can be private
) : CrimeHolderBase(thisbinding) {
    override fun bind(crime: Crime) {
        super.bind(crime)
        var baseBinding: ListItemCrimePoliceRequiredBinding = binding as ListItemCrimePoliceRequiredBinding
        baseBinding.crimeTitle.text = crime.title
    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolderBase>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : CrimeHolderBase {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == 0) {
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            return CrimeHolder(binding)
        } else {
            val binding = ListItemCrimePoliceRequiredBinding.inflate(inflater, parent, false)
            return CrimeHolderPolice(binding)
        }
    }

    override fun onBindViewHolder(holder: CrimeHolderBase, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun getItemViewType(position: Int): Int {
        if(crimes[position].requiresPolice)
            return 1
        return 0
    }

}
