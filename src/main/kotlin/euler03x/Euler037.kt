package euler03x

import common.Numbers
import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/13/16.
 */
object Euler037 {
    private val copyPasta = """
Truncatable primes
Problem 37
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
"""
    private val initialThoughts = """
    
"""

    private val NotTruncatable = setOf(2, 3, 5, 7)

    fun isTruncatablePrime(x: Int): Boolean {
        if (x in NotTruncatable) return false
        val nums = ArrayList<Int>()
        nums.add(x)
        val xarr = Numbers.int2intArray(x)
        for (i in 1..xarr.lastIndex) {
            val l2r = xarr.sliceArray(i..xarr.lastIndex)
            nums.add(Numbers.intArray2int(l2r))
            val r2l = xarr.sliceArray(0..xarr.lastIndex - i)
            nums.add(Numbers.intArray2int(r2l))
        }
        //println("my nums = $nums")
        return nums.all { Prime.isPrime(it) }
    }

    // there are 11
    val truncatablePrimes: List<Int> by lazy {
        val list = ArrayList<Int>()
        var i = 3
        do {
            if (isTruncatablePrime(i)) {
                list.add(i)
            }
            i += 1
        } while (list.size < 11)
        list
    }

    fun answer(): Int = truncatablePrimes.sum()
}