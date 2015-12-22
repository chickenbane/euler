package euler00x

import java.util.*

//Largest prime factor
//Problem 3
//The prime factors of 13195 are 5, 7, 13 and 29.
//
//What is the largest prime factor of the number 600851475143 ?

val stupidNum = 600851475143

fun bruteForce(): Long {
    var factor = 2L
    for (i in 2..stupidNum) {
        if (stupidNum % i == 0L) {
            factor = i
        }
    }
    return factor
}
// this did not complete in an hour, so I guess I should not do brute force lol


fun factor(n: Long): Pair<Long, Long> {
    for (i in 2..n) {
        if (n % i == 0L) {
            return i to n/i
        }
    }
    return 1L to n
}

fun notBruteForce(): Long {
    var factors = factor(stupidNum)
    while (factors.first != 1L) {
        println("factors: $factors")
        factors = factor(factors.second)
    }
    return factors.second
}
// this works!  let's double tidy it up

fun Pair<Long, Long>.isPrimeFactor(): Boolean = this.first == 1L || this.second == 1L

fun Pair<Long, Long>.nonOnes(): List<Long> = this.toList().filter { it != 1L }

fun findFactors(n: Long): List<Long> {
    val primeFactors = ArrayList<Long>()
    val toFactor = ArrayList<Long>()
    toFactor.add(n)
    while (toFactor.isNotEmpty()) {
        val x = toFactor.removeAt(0)
        val pair = factor(x)
        if (pair.isPrimeFactor()) {
            primeFactors.addAll(pair.nonOnes())
        } else {
            toFactor.addAll(pair.nonOnes())
        }
    }

    return primeFactors
}


fun main(args: Array<String>) {
    val factorList = findFactors(stupidNum)
    println("my answer = ${factorList.sorted()}")
    val product = factorList.fold(1L) { acc, i -> acc * i }
    println("double check: $product")
}
