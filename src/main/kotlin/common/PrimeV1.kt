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
object PrimeV1 {
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
    fun factorize(x: Int): List<Int> {
        require(x > 0) { "can't factorize x=$x"}
        return euler00x.factorize(x)
    }

    // from euler027
    //fun isPrime(x: Int): Boolean = if (x <= 0) false else factorize(x) == listOf(x)

    // rewritten euler037
    // isPrime() is frequently called in loops so here's a version that creates no objects
    fun isPrime(x: Int): Boolean {
        if (x <= 1) return false
        if (x == 2) return true
        val sqrt: Double = Math.sqrt(x.toDouble())
        val ceil = Math.ceil(sqrt).toInt()
        return (2..ceil).none { x % it == 0 }
    }

    // primeFactors(12) = setOf(2, 3)
    fun primeFactors(x: Int): Set<Int> = factorize(x).toSet()

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

    // proper divisors of n (numbers less than n which divide evenly into n).
    // properDivisors(28) == setOf(1, 2, 4, 7, 14)
    // Prime.properDivisors(220) == setOf(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110)
    // from Euler021
    fun properDivisors(n: Int): Set<Int> = divisors(n).filter { it != n }.toSet()
}