package euler04x

import common.Prime

/**
 * Created by joeyt on 2/21/16.
 */
object Euler047 {
    private val copyPasta = """
Distinct primes factors
Problem 47
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
"""
    private val initialThoughts = """
   now seems like a great time to rewrite Prime.factorize() to use refactored isPrime
"""

    fun firstTwo(): Int {
        var num = 2
        while (true) {
            num += 1
            val pf = Prime.factorize(num).toSet()
            if (pf.size != 2) continue
            val pf1 = Prime.factorize(num + 1).toSet()
            if (pf1.size == 2) return num
        }
    }

    fun firstThree(): Int {
        var num = 2
        while (true) {
            num += 1
            val pf = Prime.factorize(num).toSet()
            if (pf.size != 3) continue
            val pf1 = Prime.factorize(num + 1).toSet()
            if (pf1.size != 3) continue
            val pf2 = Prime.factorize(num + 2).toSet()
            if (pf2.size == 3) return num
        }
    }

    fun firstFour(): Int {
        var num = 2
        while (true) {
            num += 1
            val pf = Prime.factorize(num).toSet()
            if (pf.size != 4) continue
            val pf1 = Prime.factorize(num + 1).toSet()
            if (pf1.size != 4) continue
            val pf2 = Prime.factorize(num + 2).toSet()
            if (pf2.size != 4) continue
            val pf3 = Prime.factorize(num + 3).toSet()
            if (pf3.size == 4) return num
        }
    }

}