package com.msoe.bnrtextapps.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.msoe.bnrtextapps.criminalintent.Crime


// See app build.gradle - exportSchema=false solves the challenge in Ch 12 by disabling the export
@Database(entities = [ Crime::class ], version=1, exportSchema=false)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}