package euler00x

import java.util.*

//10001st prime
//Problem 7
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10 001st prime number?


class Euler007 {
    fun reduce(n: Int): Pair<Int, Int> {
        for (i in 2..n) {
            if (n % i == 0) {
                return i to n / i
            }
        }
        return 1 to n
    }

    fun Pair<Int, Int>.isPrimeFactor(): Boolean = first == 1 || second == 1

    fun factorize(n: Int): List<Int> {
        val primeFactors = ArrayList<Int>()
        val toFactor = ArrayList<Int>()
        toFactor.add(n)
        while (toFactor.isNotEmpty()) {
            val x = toFactor.removeAt(0)
            val pair = reduce(x)
            if (pair.isPrimeFactor()) {
                primeFactors.addAll(pair.toList())
            } else {
                toFactor.addAll(pair.toList())
            }
        }

        return primeFactors.filter { it != 1 }
    }
}

// only works if isPrimeFactor() == true
fun Pair<Int, Int>.getPrime(): Int = if (first == 1) second else first

fun findPrime(nth: Int): Int {
    require(nth > 0)
    val primes = ArrayList<Int>()
    var i = 2
    while (primes.size < nth) {
        val pair = reduce(i)
        if (pair.isPrimeFactor()) {
            primes.add(pair.getPrime())
        }
        i += 1
    }
    return primes[nth-1]
}

fun main(args: Array<String>) {
    println("my answer = ${findPrime(10001)}")
}