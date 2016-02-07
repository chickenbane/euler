package euler02x

import euler01x.Euler015

/**
 * Created by joeyt on 1/21/16.
 */
object Euler020 {
    private val copyPasta = """
Factorial digit sum
Problem 20
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
"""
    private val initialThoughts = """
combine problem 15 and 16, maybe make something reusable? lol
"""

    fun sumOfDigits(stringOfDigits: String): Int {
        require(stringOfDigits.all { it.isDigit() })
        return stringOfDigits.toCollection(arrayListOf<Char>()).map { it.toString().toInt() }.sum()
    }

    fun sumOfFactorial(number: Int): Int {
        val factorial = Euler015.factorialBd(number)
        return sumOfDigits(factorial.toString())
    }


}