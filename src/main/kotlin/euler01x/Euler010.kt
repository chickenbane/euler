package euler01x

import common.Prime
import java.util.*

/**
 * Created by joeyt on 12/25/15.
 */
object Euler010 {
    private val copyPasta = """
Summation of primes
Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
"""
    private val initialThoughts = """
    
"""

    // ArrayList of the primes from 1 to n
    // adapted from euler007
    fun findPrimes(n: Int): ArrayList<Int> {
        require(n > 0)
        val primes = ArrayList<Int>(n)
        var i = 2
        while (primes.size < n) {
            val factors = Prime.reduce(i)
            if (factors.isPrimeFactor()) {
                primes.add(factors.getPrime())
            }
            i += 1
        }
        return primes
    }

    // ArrayList of the primes from 1 to n
    // adapted from euler007
    fun findPrimesLessThan(lessThan: Int): ArrayList<Int> {
        require(lessThan > 2)
        val primes = ArrayList<Int>()
        var i = 2
        while (i < lessThan) {
            val factors = Prime.reduce(i)
            if (factors.isPrimeFactor()) {
                primes.add(factors.getPrime())
            }
            i += 1
        }
        return primes
    }

}

// This worked, but took too long.  FYI maybe do something smarter next time lol.
fun main(args: Array<String>) {
    val primeList = Euler010.findPrimesLessThan(2000000)
    val primeListLong = primeList.map { it.toLong() }
    println("my answer = ${primeListLong.sum()}")
}