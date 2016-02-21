package euler04x

import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/21/16.
 */
object Euler046 {
    private val copyPasta = """
Goldbach's other conjecture
Problem 46
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
"""
    private val initialThoughts = """
    incrementing, find if prime. if not, check if goldbach
"""


    fun answer(): Int {
        val primes = LinkedHashSet<Int>()
        var curr = 2
        while (true) {
            if (Prime.isPrime(curr)) {
                primes.add(curr)
            } else if (curr % 2 != 0) {  // odd composite number
                if (!goldbach(primes, curr)) {
                    return curr
                }
            }
            curr += 1
        }
    }

    fun goldbach(primes: LinkedHashSet<Int>, num: Int): Boolean {
        for (p in primes) {
            var exceeds = false
            var sqrt = 1
            do {
                val sum = p + (2 * sqrt * sqrt)
                if (sum == num) return true
                if (sum > num) exceeds = true
                sqrt += 1
            } while (!exceeds)
        }

        return false
    }

}