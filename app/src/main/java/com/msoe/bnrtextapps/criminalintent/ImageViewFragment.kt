package com.msoe.bnrtextapps.criminalintent

import android.app.DatePickerDialog
import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import com.msoe.bnrtextapps.criminalintent.databinding.FragmentCrimeDetailBinding
import com.msoe.bnrtextapps.criminalintent.databinding.FragmentImageViewBinding
import java.io.File
import java.util.Calendar
import java.util.GregorianCalendar

class ImageViewFragment : DialogFragment() {

    private var _binding: FragmentImageViewBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val args: ImageViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentImageViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    //dialog view is ready
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.capturedImage.setImageURI(args.photoUri)
    }
}