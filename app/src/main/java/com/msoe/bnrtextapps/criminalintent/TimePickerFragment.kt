package com.msoe.bnrtextapps.criminalintent

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import java.util.Calendar
import java.util.GregorianCalendar

class TimePickerFragment : DialogFragment() {

    private val args: TimePickerFragmentArgs by navArgs()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val timeListener = TimePickerDialog.OnTimeSetListener {
                timePicker, hour, minute ->

            var refCal = Calendar.getInstance()
            refCal.time = args.crimeTime

            val resultDate = GregorianCalendar(
                refCal.get(Calendar.YEAR),
                refCal.get(Calendar.MONTH),
                refCal.get(Calendar.DATE),
                hour,
                minute).time

            setFragmentResult(REQUEST_KEY_DATE,
                bundleOf(BUNDLE_KEY_DATE to resultDate)
            )
        }
        val calendar = Calendar.getInstance()
        calendar.time = args.crimeTime
        val initialHour = calendar.get(Calendar.HOUR)
        val initialMinute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireContext(),
            timeListener,
            initialHour,
            initialMinute,
            false // 24 hr view
        )
    }
    companion object {
        const val REQUEST_KEY_DATE = "REQUEST_KEY_DATE"
        const val BUNDLE_KEY_DATE = "BUNDLE_KEY_DATE"
    }
}