package euler03x

import common.Numbers
import java.math.BigDecimal
import java.util.*

/**
 * Created by joeyt on 2/8/16.
 */
object Euler030 {
    private val copyPasta = """
Digit fifth powers
Problem 30
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
"""
    private val initialThoughts = """
    2^5 = 32
    3^5 = 243
    9^5 = 59049

    so let's say numbers to 200k?
"""


    val pows = (0L..9).map { BigDecimal.valueOf(it).pow(5).toInt() }.toIntArray()

    fun answer(): Int {
        val list = ArrayList<Int>()
        for (i in 2..1000000) {
            val ia = Numbers.int2intArray(i)
            val sum = ia.map { pows[it] }.sum()
            if (i == sum) {
                println("i=$i iaMap=${ia.map{pows[it]}.joinToString(" ")}")
                list.add(i)
            }
        }
        return list.sum()
    }
}