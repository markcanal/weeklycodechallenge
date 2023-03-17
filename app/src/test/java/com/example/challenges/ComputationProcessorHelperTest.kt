package com.example.challenges

import com.example.challenges.ComputationProcessorHelper.calculatorSample
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class ComputationProcessorHelperTest{
    @Test
    fun testCalculatorSample() {
        val input1 = 5
        val input2 = 3
        val expectedOutput = "1, 2, 3\n2, 4, 6\n3, 6, 9\n4, 8, 12\n5, 10, 15\n"
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        calculatorSample(input1, input2)

        assertEquals(expectedOutput, outputStream.toString())
    }
}