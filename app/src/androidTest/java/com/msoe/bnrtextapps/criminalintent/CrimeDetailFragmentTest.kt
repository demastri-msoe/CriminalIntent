package com.msoe.bnrtextapps.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class CrimeDetailFragmentTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun validateSolvedIsPassed() {
        var scenario = launchFragmentInContainer<CrimeDetailFragment>()
        scenario.onFragment { fr ->
            assertFalse(fr.crime.isSolved)
            fr.binding.crimeSolved.performClick();
            assertTrue(fr.crime.isSolved)
        }
    }

    @Test
    fun validateTitleIsPassed() {
        var scenario = launchFragmentInContainer<CrimeDetailFragment>()
        scenario.onFragment { fr ->
            assertEquals("", fr.crime.title)
            fr.binding.crimeTitle.setText( "New Title" )
            assertEquals("New Title", fr.crime.title)
        }
    }
}