package com.msoe.bnrtextapps.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID
import kotlin.coroutines.CoroutineContext

private const val TAG = "CrimeListViewModel"
class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()

    val crimes = crimeRepository.getCrimes()

    init {
        viewModelScope.launch {  }
    }
}