package common

import euler01x.Euler010
import euler01x.Euler012
import java.util.*

/**
 * From euler005, which was a rewrite of euler003
 *
 * euler007
 * Created by joeyt on 12/25/15.
 */
object Prime {
    class Factors(val pair: Pair<Int, Int>) {
        // from euler005
        fun isPrimeFactor(): Boolean = (pair.first == 1 || pair.second == 1)

        // from euler007
        fun getPrime(): Int {
            require(isPrimeFactor())
            return if (pair.first == 1) pair.second else pair.first
        }

    }
    // pair returned are factors of x, may be (1, x)
    // from euler005, which was a rewrite of euler003
    fun reduce(x: Int): Factors {
        val pair = euler00x.reduce(x)
        return Factors(pair)
    }

    // returns the prime factors of x
    // from euler005, which was a rewrite of euler003
    // factorize(12) == listOf(2, 2, 3)
    fun factorize(x: Int): List<Int> = euler00x.factorize(x)

    // returns the nth prime.  findPrime(1) = 2
    // from euler007
    fun findPrime(nth: Int): Int = euler00x.findPrime(nth)

    // ArrayList of the primes from 1 to n
    // from Euler010
    fun findPrimes(n: Int): ArrayList<Int> = Euler010.findPrimes(n)

    // ArrayList of the primes from 1 to n
    // from Euler010
    fun findPrimesLessThan(lessThan: Int): ArrayList<Int> = Euler010.findPrimesLessThan(lessThan)

    // divisors(28) == setOf(1,2,4,7,14,28)
    // from Euler012
    fun divisors(n: Int): Set<Int> = Euler012.divisors(n)
}