package com.example.challenges

import java.lang.Exception

object ComputationProcessorHelper {

    fun calculatorSample(input1: Int, input2: Int) {
        val baseNumList: ArrayList<Int> = arrayListOf()
        val multiplierList: ArrayList<Int> = arrayListOf()
        val resultMap: MutableMap<Int, ArrayList<Int>> = mutableMapOf()
        if (input1 < 0 || input2 < 0) {
            print("Inputs required positive number. Please try again")
        } else {
            var i = 0
            while (input1 != i) {
                i++
                baseNumList.add(i)
            }
            var y = 0
            while (input2 != y) {
                y++
                multiplierList.add(y)
            }
            for (i in baseNumList) {
                val arrayList: ArrayList<Int> = ArrayList()
                for (b in multiplierList) {
                    arrayList.add(i * b)
                }
                resultMap[i] = arrayList
            }
            for (i in resultMap) {
                println(i.value.toString().replace("[", "").replace("]", ""))
            }
        }
    }

    fun convertMilitaryToStandardTime(string: String): String {
        return try {
            val hoursMinute = string.split(":")
            if (hoursMinute[1].length > 2) {
                "Acceptable format is HH:MM or H:M"
            } else if (hoursMinute[1].toInt() > 60) {
                "Minutes are between 0 t0 60"
            } else {
                val hours = hoursMinute[0].toIntOrNull()
                val minutes = if (hoursMinute[1].toIntOrNull() != null) {
                    digitsFormatter(hoursMinute[1].toInt())
                } else {
                    0L
                }

                if (hours != null) {
                    if (hours > 24) {
                        "Time more than 24hrs is not supported"
                    } else {
                        when (hours) {
                            in 13..23 -> {
                                "${digitsFormatter(hours - 12)}:$minutes pm"
                            }

                            12 -> {
                                "$hours:$minutes pm"
                            }

                            0 -> {
                                "${hours + 12}:$minutes am"
                            }

                            24 -> {
                                "${digitsFormatter(hours - 12)}:$minutes am"
                            }

                            else -> {
                                "${digitsFormatter(hours)}:$minutes am"
                            }
                        }
                    }
                } else {
                    "Something went wrong with your input"
                }
            }
        } catch (e: Exception) {
            "Please enter time as HH:MM"
        }
    }

    private fun digitsFormatter(value: Int): String {
        return String.format("%02d", value)
    }

    fun timeLogCalculator(tIn: String?, tBreak: String?, breakIn: String?, out: String?): String {
        return try {
            var amTotal = 0.0
            var pmTotal = 0.0
            if (tIn != null && tBreak != null && breakIn != null && out != null) {
                amTotal = stringTimeConverterToDouble(tBreak) - stringTimeConverterToDouble(tIn)
                pmTotal = stringTimeConverterToDouble(out) - stringTimeConverterToDouble(breakIn)
            } else if (tIn == null && tBreak == null) {
                amTotal = 0.0
                pmTotal = stringTimeConverterToDouble(out) - stringTimeConverterToDouble(breakIn)
            } else if (breakIn == null && out == null) {
                amTotal = stringTimeConverterToDouble(tBreak) - stringTimeConverterToDouble(tIn)
                pmTotal = 0.0
            } else if (tBreak == null && breakIn == null) {
                amTotal = stringTimeConverterToDouble(out) - stringTimeConverterToDouble(tIn)
                pmTotal = 0.0
            }

            val total = amTotal + pmTotal
            return "${String.format("%02d",total)}"
        } catch (e: Exception) {
            print(e.toString())
            "Time inputs is HH:MM or H:M"
        }
    }

    private fun stringTimeConverterToDouble(str: String?): Double {
        return if (str != null) {
            val timeList = str.split(":")
            val hr = timeList[0].toDouble()
            (60 * hr + timeList[1].toDouble()) / 60
        } else {
            0.0
        }
    }
}