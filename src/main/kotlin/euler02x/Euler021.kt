package euler02x

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
    val allDn[1..100000] = d(i)

traverse allDn to find pairs. then smu!
"""

}