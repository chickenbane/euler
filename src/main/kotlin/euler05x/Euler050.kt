package euler05x

import common.Prime
import java.math.BigInteger

/**
 * Created by joeyt on 2/22/16.
 */
object Euler050 {
    private val copyPasta = """
Consecutive prime sum
Problem 50
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
"""
    private val initialThoughts = """
   oh nice my FIRST_PRIMES was made perfectly for this!
"""

    val primeInts = Prime.FIRST_PRIMES.map { it.num }
    val last = primeInts.last()
    val primeSet = primeInts.toSet()

    fun answer(): Int {
        var sumLen = 0
        var sum = 0
        for (i in Prime.FIRST_PRIMES.indices) {
            val longestSum: List<Int> = findConsecSum(i)
            if (longestSum.size > sumLen) {
                sumLen = longestSum.size
                sum = longestSum.sum()
                println("sum=$sum len=$sumLen list=[${longestSum.first()}..${longestSum.last()}]")
            }
        }
        return sum
    }

    fun findConsecSum(startIdx: Int): List<Int> {
        var toIndex = startIdx + 21 // start with 21 terms
        var biggest = toIndex
        while (toIndex < primeInts.size) {
            val subList = primeInts.subList(startIdx, toIndex)
            val sum = subList.sum()
            if (sum > last) return primeInts.subList(startIdx, biggest)
            if (sum in primeSet) biggest = toIndex
            toIndex += 1
        }
        if (biggest > primeInts.lastIndex) return emptyList()
        return primeInts.subList(startIdx, biggest)
    }

}