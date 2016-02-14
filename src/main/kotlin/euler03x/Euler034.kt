package euler03x

import common.Numbers
import java.math.BigInteger

/**
 * Created by joeyt on 2/13/16.
 */
object Euler034 {
    private val copyPasta = """
Digit factorials
Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.
"""
    private val initialThoughts = """
    
"""

    fun sumDigitFactorial(x: Int): BigInteger {
        val arr = Numbers.int2intArray(x)
        val factorials = arr.map { Numbers.factorial(it) }
        return factorials.reduce { x, y -> x + y }
    }


}