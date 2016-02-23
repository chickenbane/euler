package euler04x

import java.math.BigInteger

/**
 * Created by joeyt on 2/22/16.
 */
object Euler048 {
    private val copyPasta = """
Self powers
Problem 48
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
"""
    private val initialThoughts = """
    please
"""

    val sum by lazy { (1..1000).map { BigInteger.valueOf(it.toLong()).pow(it) }.reduce { a, b -> a + b } }

    val answer by lazy {
        val str = sum.toString()
        val range = str.length-10..str.lastIndex
        str.substring(range)
    }
}