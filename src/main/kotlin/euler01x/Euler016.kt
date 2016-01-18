package euler01x

import java.math.BigDecimal

/**
 * Created by joeyt on 1/15/16.
 */
object Euler016 {
    private val copyPasta = """
Power digit sum
Problem 16
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
"""
    private val initialThoughts = """
bleh. man, my brain doesn't work fast with math problems.
let's hope I don't overflow bigdecimal!
"""

    fun powString(base: Int, pow: Int) = BigDecimal(base).pow(pow).toString()


    // v1.  UGH, because string.toArrayList() returns a list<Char>, and as we saw earlier char.toInt() doesn't do what we want.
    // I THOUGHT I ALREADY LEARNED THIS, bleh.
    fun sumOfDigits(base: Int, pow: Int) = BigDecimal(base).pow(pow).toString().toArrayList().map { it.toInt() }.sum()

    fun sumOfDigitsV2(base: Int, pow: Int) = BigDecimal(base).pow(pow).toString().toArrayList().map { it.toString().toInt() }.sum()

}