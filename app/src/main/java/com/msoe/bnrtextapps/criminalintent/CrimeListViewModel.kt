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
    val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "init starting")
        CoroutineScope(coroutineContext).launch {
            Log.d(TAG, "coroutine launched")
            crimes += loadCrimes()
            Log.d(TAG, "Loading crimes finished ("+crimes.size+")")
        }
    }


    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}