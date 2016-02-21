package euler04x

import common.Numbers
import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/20/16.
 */
object Euler041 {
    private val copyPasta = """
Pandigital prime
Problem 41
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
"""
    private val initialThoughts = """
    assume n <= 9?
"""

    val Digits = Array(10) {
        (1..it).toSet()
    }


    // v32 too specialized for the problem
    // v38 only validates 1 to 9 rather than 1 to n
    fun isPandigital(str: String): Boolean {
        val list = str.toCharArray().map { it.toString().toInt() }
        return Digits[list.size] == list.toSet()
    }

    fun answerBrute(): Int {
        for (i in 987654321.downTo(2143)) {
            if (Prime.isPrime(i) && Numbers.isPandigital(i.toString())) {
                return i
            }
        }
        throw IllegalStateException("this sucks")
    }

    fun primePandigitals(n: Int): Set<Int> {
        val set = LinkedHashSet<Int>()
        val array = (1..n).toList().toIntArray()
        do {
            val num = Numbers.intArray2int(array)
            if (Prime.isPrime(num)) {
                set.add(num)
            }
            val again = Numbers.nextLexPermutation(array)
        } while (again)
        return set
    }

    fun answer(): Int {
        for (i in 9.downTo(4)) {
            val primes = primePandigitals(i)
            if (primes.isNotEmpty()) {
                return primes.max()!!
            }
        }
        throw IllegalStateException("better?")
    }
}