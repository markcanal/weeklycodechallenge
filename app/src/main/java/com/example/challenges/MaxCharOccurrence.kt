package com.example.challenges


class MaxCharOccurrence {
    fun getCharWithMaxOccurrence(char: String): String {
        val processedString: MutableMap<String, Int> = mutableMapOf()
        val charArray: CharArray = char.toCharArray()
        for (item in charArray) {
            if (processedString.containsKey(item.toString())) {
                processedString[item.toString()] = processedString[item.toString()]?.plus(1) ?: 0
            } else {
                processedString[item.toString()] = 1
            }
        }
        var charWithMaxValue = processedString.maxBy { it.value }
        return charWithMaxValue.key
    }

    fun getLongestWordFromString(char: String): String? {
        var maxLength = getLongestSizeFromString(char)
        var wordCollection = char.split(" ")
        var result: String? = null
        for (i in wordCollection) {
            result = if (i.length == maxLength) {
                i
            } else {
                null
            }
        }
        return result
    }

    fun reverseTheWord(char: String): String {
        val charArray: CharArray = char.toCharArray()
        char.indices.forEach { charArray[char.length - it - 1] = char[it] }
        return String(charArray)
    }

    private fun getLongestSizeFromString(char: String): Int {
        var initialLength: Int = 0
        var currentLength: Int = 0

        for (i in char) {
            if (i != ' ') {
                currentLength++
            } else {
                initialLength = Math.max(currentLength, currentLength)
                currentLength = 0
            }
        }
        return Math.max(initialLength, currentLength)
    }
}