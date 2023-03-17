package com.example.challenges

import com.example.challenges.ComputationProcessorHelper.calculatorSample
import com.example.challenges.ComputationProcessorHelper.convertMilitaryToStandardTime
import com.example.challenges.ComputationProcessorHelper.timeLogCalculator
import java.lang.NumberFormatException
import kotlin.system.exitProcess

fun main() {
//    val max = MaxCharOccurrence()
//    println( "${ max.getCharWithMaxOccurrence("SsssSSample") }")
//    println( "${max.getLongestWordFromString(" The manifestation")}")
//    println( "${ max.reverseTheWord("olleH") }")
//    runCalc()
//    timeConverter()
    attendanceLogComputation()
}

fun runCalc() {
    print(
        "*****************************\n" +
                "Calculator accept Digits only.\n" +
                "*****************************\n"
    )

    print("Enter base number: ")
    val baseNumber = try {
        Integer.valueOf(readln())
    } catch (e: NumberFormatException) {
        null
    }
    print("Enter Multiplier: ")
    val multiplier = try {
        Integer.valueOf(readln())
    } catch (e: NumberFormatException) {
        null
    }
    if (baseNumber != null && multiplier != null) {
        if (baseNumber < 0 && multiplier < 0) {
            print("Inputs required positive number. Please try again\n")
            runCalc()
        } else {
            calculatorSample(baseNumber, multiplier)
        }
    } else {
        print("This program accept numbers only. Please try again\n")
        runCalc()
    }
}

fun timeConverter() {
    print(
        "\n********************************\n" +
                "Military time to Standard time.\n" +
                "press x or X to exit\n" +
                "********************************\n"
    )
    print("Enter time (H:M): ")
    var time = readln()

    if (time == "x" || time == "X") {
        print("Exit program ... ")
        exitProcess(0)
    } else {
        print(convertMilitaryToStandardTime(time))
        timeConverter()
    }
}

fun attendanceLogComputation() {
    print(
        "\n********************************\n" +
                "   Attendance Log Calculator.\n" +
                "     press x or X to exit\n" +
                "********************************\n"
    )
    print("Enter time in (H:M): ")
    var timeInAm = try {
        readln()
    } catch (e: Exception) {
        null
    }
    print("Enter break (H:M): ")
    var timeOutAm = try {
        readln()
    } catch (e: Exception) {
        null
    }
    print("Enter break In (H:M): ")
    var timeInPm = try {
        readln()
    } catch (e: Exception) {
        null
    }
    print("Enter break In (H:M): ")
    var timeOutPm = try {
        readln()
    } catch (e: Exception) {
        null
    }

    print(timeLogCalculator(timeInAm, timeOutAm, timeInPm, timeOutPm))
}
