package euler02x

import common.Prime
import java.util.*

/**
 * Created by joeyt on 1/24/16.
 */
object Euler023 {
    private val copyPasta = """
Non-abundant sums
Problem 23
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as
the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
even though it is known that the greatest number that cannot be expressed as the sum of two abundant
 numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
"""
    private val initialThoughts = """
write fun sumProperDivisors(x: Int): Int
write fun calcPerfectNumberType(x: Int): PerfectNumberType


"""

    fun sumProperDivisors(x: Int): Int = Prime.properDivisors(x).sum()

    fun calcPerfectNumberType(n: Int): PerfectNumberType = sumProperDivisors(n).run {
            // this == sum
            when {
                this == n -> PerfectNumberType.PERFECT
                this < n -> PerfectNumberType.DEFICIENT
                else -> PerfectNumberType.ABUNDANT
            }
        }

    enum class PerfectNumberType { DEFICIENT, PERFECT, ABUNDANT }

    val top = 28123

    // because I am stubborn and want a 1-based array, index zero will be DEFICIENT.
    val numToType: Array<PerfectNumberType> by lazy {
        Array<PerfectNumberType>(top+1) { if (it==0) PerfectNumberType.DEFICIENT else calcPerfectNumberType(it) }
    }

    // in the numToType array there are ~7000 ABUNDANTS
    val abundants: List<Int> by lazy {
        val list = ArrayList<Int>(7000)
        for ((i, type) in numToType.withIndex()) {
            if (type == PerfectNumberType.ABUNDANT) {
                list.add(i)
            }
        }
        Collections.unmodifiableList(list)
    }

    val abundantSums: Set<Int> by lazy {
        val set = HashSet<Int>()
        for (a in abundants) {
            for (b in abundants) {
                set.add(a+b)
            }
        }
        Collections.unmodifiableSet(set)
    }

}

