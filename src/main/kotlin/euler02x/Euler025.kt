package euler02x

import java.math.BigInteger
import java.util.*

/**
 * Created by joeyt on 2/2/16.
 */
object Euler025 {
    private val copyPasta = """
1000-digit Fibonacci number
Problem 25
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
"""
    private val initialThoughts = """
    this sequence is a little different than the Euler002
    oh, 1000 digits is BigInt territory lols
    Also, add a lookup so we don't have to recalcuate our old stuff lols
"""

    val lookup = HashMap<Int, BigInteger>(50)

    fun bigFib(n: Int): BigInteger {
        require(n > 0)
        val f = when (n) {
            1, 2 -> BigInteger.ONE
            in lookup -> lookup[n]!!
            else -> bigFib(n - 2) + bigFib(n - 1)
        }
        lookup[n] = f
        if (lookup.size > 100) {
            val removeKeys = lookup.keys.filter { it < n - 2 }
            removeKeys.forEach { lookup.remove(it) }
        }
        return f
    }

    fun countDigits(n: BigInteger): Int = n.toString().length

    fun firstTermWithDigits(digits: Int): Int {
        require(digits > 0)
        var term = 0
        do {
            term += 1
            val fib = bigFib(term)
            val d = countDigits(fib)
            if (term % 10 == 0) println("term=$term fib=$fib digits=$d")
        } while (d < digits)
        return term
    }

}