package com.msoe.bnrtextapps.criminalintent

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.msoe.bnrtextapps.criminalintent.database.CrimeDatabase
import com.msoe.bnrtextapps.criminalintent.database.migration_1_2
import com.msoe.bnrtextapps.criminalintent.database.migration_2_3
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.UUID

private const val TAG = "CrimeRepository"

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(
    context: Context,
    private val coroutineScope: CoroutineScope = GlobalScope
) {

    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .allowMainThreadQueries()
        .addMigrations(migration_1_2, migration_2_3)
        .build()

    fun getCrimes(): Flow<List<Crime>> {
        Log.d(TAG, "in Repo:getCrimes()")
        return database.crimeDao().getCrimes()
    }

    suspend fun getCrime(id: UUID): Crime = database.crimeDao().getCrime(id)

    fun updateCrime(crime: Crime) {
        coroutineScope.launch {
            database.crimeDao().updateCrime(crime)
        }
    }

    suspend fun addCrime(crime: Crime) {
            database.crimeDao().addCrime(crime)
    }

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}