package euler04x

import common.Numbers
import java.util.*

/**
 * Created by joeyt on 2/20/16.
 */
object Euler043 {
    private val copyPasta = """
Sub-string divisibility
Problem 43
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
"""
    private val initialThoughts = """
    ugh, my isPandigital still doesn't transfer
"""


    val Digits09 = Array(10) { (0..it).toSet() }

    fun isPandigital09(str: String): Boolean {
        val list = str.toCharArray().map { it.toString().toInt() }
        return Digits09[list.size - 1] == list.toSet()
    }

    // returns "substring" as an int
    // range is 1-based like d1 d2 etc above
    // so this function converts range to 0-based
    fun IntArray.sub(range: IntRange): Int {
        require (range.start - 1 >= 0 && range.endInclusive - 1 <= lastIndex)
        val sb = StringBuilder()
        for (i in range) {
            sb.append(this[i - 1])
        }
        return sb.toString().toInt()
    }

    private val rangeToDivBy = HashMap<IntRange, Int>().apply {
        put((2..4), 2)
        put((3..5), 3)
        put((4..6), 5)
        put((5..7), 7)
        put((6..8), 11)
        put((7..9), 13)
        put((8..10), 17)
    }

    fun subDiv(array: IntArray): Boolean {
        for ((k,v) in rangeToDivBy) {
            val sub = array.sub(k)
            if (sub % v != 0) {
                return false
            }
        }
        return true
    }

    fun answer(): Set<Long> {
        val set = LinkedHashSet<Long>()
        val array = (0..9).toList().toIntArray()
        do {
            val numStr = array.joinToString("")
            if (subDiv(array) && isPandigital09(numStr)) {
                val num = numStr.toLong()
                set.add(num)
            }
            val again = Numbers.nextLexPermutation(array)
        } while (again)
        return set
    }


}