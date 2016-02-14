package euler03x

import common.Numbers
import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/13/16.
 */
object Euler035 {
    private val copyPasta = """
Circular primes
Problem 35
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
"""


    fun rotations(x: Int): IntArray {
        val digits = Numbers.int2intArray(x)
        val rotations = ArrayList<Int>()
        rotations.add(x)
        do {
            val next = digits.rotate()
            val again = next != x
            if (again) {
                rotations.add(next)
            }
        } while (again)
        return rotations.toIntArray()
    }


    // this is doing two things:
    // 1) rotating the elements of the array around
    // 2) returning the current configuration of digits as an int
    fun IntArray.rotate(): Int {
        val first = first()
        for (i in 1..lastIndex) {
            this[i - 1] = this[i]
        }
        this[lastIndex] = first
        return joinToString("").toInt()
    }

    fun isCircularPrime(x: Int): Boolean = rotations(x).all { Prime.isPrime(it) }
}

