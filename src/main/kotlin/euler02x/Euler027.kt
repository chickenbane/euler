package euler02x

import common.PrimeV1

/**
 * Created by joeyt on 2/7/16.
 */
object Euler027 {
    private val copyPasta = """
Quadratic primes
Problem 27
Euler discovered the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
"""
    private val initialThoughts = """
    write fun numConsecutivePrimes(f: (Int) -> Int): Int
"""

    fun numConsecutivePrimes(f: (Int) -> Int): Int {
        var n = 0
        do {
            val result = f(n)
            val prime = PrimeV1.isPrime(result)
            n += 1
        } while (prime)
        return n - 1
    }

    fun quadraticFun(a: Int, b: Int): (Int) -> Int = fun(n: Int): Int = (n*n) + (a*n) + b

    private fun consec(a: Int, b: Int) = numConsecutivePrimes(quadraticFun(a, b))

    fun answer(): Int {
        var maxNum = 0
        var coefProd = 0
        for (a in -999..999) {
            for (b in -999..999) {
                val c = consec(a, b)
                if (c > maxNum) {
                    println("a = $a b = $b consec=$c")
                    maxNum = c
                    coefProd = a * b
                }
            }
        }
        return coefProd
    }

}