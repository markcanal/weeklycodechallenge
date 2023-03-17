package com.example.challenges

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MaxCharOccurrenceKtTest{
    lateinit var UIT : MaxCharOccurrence

    @Before
    fun setUp(){
        UIT = MaxCharOccurrence()
    }

    @Test
    fun maxCharOccurrenceKt_getMaxOccurrenceWord(){
        val string :String = "wwwwwwrrAA"
        val result = UIT.getCharWithMaxOccurrence(string)
        assertEquals("w",result)
    }

    @Test
    fun maxCharOccurrenceKt_getLongestWordFromString_with_string_not_null(){
        val string: String = "The given problem"
        val result = UIT.getLongestWordFromString(string)
        assertEquals("problem",result)
    }

    @Test
    fun maxCharOccurrenceKt_getLongestWordFromString_when_null(){
        val string: String? = null
        val result = string?.let { UIT.getLongestWordFromString(it) }
        assertEquals(null,result)
    }

    @Test
    fun maxCharOccurrenceKt_reverseTheWord(){
        val string = "Renovation"
        val result = UIT.reverseTheWord(string)
        assertEquals("noitavoneR",result)
    }
}