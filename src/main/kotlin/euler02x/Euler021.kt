package euler02x

import common.PrimeV1
import java.util.*

/**
 * Created by joeyt on 1/23/16.
 */
object Euler021 {
    private val copyPasta = """
Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
"""
    private val initialThoughts = """
go through old problems to find
    fun properDivisors(n): IntArray

then
    fun d(n) = properDivsors(n).sum
    val allDn[1..10000] = d(i)

traverse allDn to find pairs. then sum!
"""

    fun sumOfProperDivisors(n: Int): Int = PrimeV1.properDivisors(n).sum()

    fun isAmicablePair(a: Int, b: Int): Boolean = sumOfProperDivisors(a) == b && sumOfProperDivisors(b) == a

    val tenThou = 10000

    // gotcha!  using the IntArray(n) { lambda } constructor means your lambda must anticipate being called with zero
    val allDn: IntArray by lazy { IntArray(tenThou){ if (it == 0) 0 else sumOfProperDivisors(it) } }

    val allAmicableNums: Set<Int> by lazy {
        val set = HashSet<Int>()
        for (a in 1..tenThou) {
            // d(a) = b
            val b = sumOfProperDivisors(a)
            // don't allow b == 0
            if (b == 0) {
                continue
            }
            // d(b) = x
            val x = sumOfProperDivisors(b)
            // a != b
            if (a != b) {
                // d(b) == x == a, d(a) == b
                // isAmicablePair(a, b)
                // isAmicablePair(x, b)
                if (x == a) {
                    require(isAmicablePair(a, b))
                    require(isAmicablePair(x, b))
                    require(!isAmicablePair(a, x))
                    require(x == a)
                    set.add(a)
                    set.add(b)
                }
            }
        }
        set
    }

}