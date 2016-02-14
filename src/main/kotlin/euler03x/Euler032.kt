package euler03x

import java.util.*

/**
 * Created by joeyt on 2/9/16.
 */
object Euler032 {
    private val copyPasta = """
Pandigital products
Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
"""
    private val initialThoughts = """
    98 * 76 = 7448, so both numbers can't be two digits (only 8 characters)
    123 * 456 = 56088, so both numbers can't be three digits (11 characters)
    9 * 876 = 7884 976 * 8 = 7808, so 1 digit * 3 digits won't work
    1234 * 5 = 6170 OK

    so must be 2 digit * 3 digits and 1 digit * 4 digits
    brute forcing seems easier than doing all permutations of (1..9)
"""

    // refining this function actually was the trickiest
    fun isPandigital(x: Int, y: Int): Boolean {
        val z = x * y
        val s = "$x$y$z"
        if (s.length > 9) return false
        val digits = s.toSet()
        return digits.size == 9 && !digits.contains('0')
    }

    fun bruteForce(): Set<Pair<Int, Int>> {
        val set = HashSet<Pair<Int, Int>>()
        for (x in 12..98) {
            for (y in 123..987) {
                if (isPandigital(x, y)) {
                    set.add(x to y)
                }
            }
        }
        for (x in 1..9) {
            for (y in 1234..9876) {
                if (isPandigital(x, y)) {
                    set.add(x to y)
                }
            }
        }
        return set
    }

    fun answer(): Int {
        val set = bruteForce()
        val noDupeProducts = set.map { it.first * it.second }.toSet()
        println("my products=${noDupeProducts}")
        return noDupeProducts.sum()
    }



}