package euler02x


import common.Prime
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/24/16.
 */
class Euler021Test {
    @Test
    fun checkDemo() {
        // the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
        val expected220 = setOf(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110)
        val actual220 = Prime.properDivisors(220)
        Assert.assertEquals("Prime.properDivisors(220) == setOf(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110)", expected220, actual220)

        // properDivisors(28) == setOf(1, 2, 4, 7, 14)
        val expected28 = setOf(1, 2, 4, 7, 14)
        val actual28 = Prime.properDivisors(28)
        Assert.assertEquals("Prime.properDivisors(28) == setOf(1, 2, 4, 7, 14)", expected28, actual28)

        // The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220
        val expected284 = setOf(1, 2, 4, 71, 142)
        val actual284 = Prime.properDivisors(284)
        Assert.assertEquals("Prime.properDivisors(284) == setOf(1, 2, 4, 71, 142)", expected284, actual284)
    }

    // Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    // If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
    // For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
    // therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    @Test
    fun testSumProperDivisors() {
        // d(n) = sumOfProperDivisors(n), d(220) = 284
        // sumOfProperDivisors(220) = 284
        val actual220 = Euler021.sumOfProperDivisors(220)
        Assert.assertEquals("sumOfProperDivisors(220) = 284", 284, actual220)
        // sumOfProperDivisors(284) = 220
        val actual284 = Euler021.sumOfProperDivisors(284)
        Assert.assertEquals("sumOfProperDivisors(284) = 220", 220, actual284)
    }

    @Test
    fun testIsAmicablePair() {
        // since d(220) = 284 and d(284) = 220, isAmicablePair(220, 284) == true
        Assert.assertTrue("220, 284 are amicable", Euler021.isAmicablePair(220, 284))
        Assert.assertTrue("284, 220 are amicable", Euler021.isAmicablePair(284, 220))
    }

    @Test
    fun answer() {
        // Evaluate the sum of all the amicable numbers under 10000.
        val allAmicableNums = Euler021.allAmicableNums
        println("all amicable numbers under 10000 = $allAmicableNums")
        Assert.assertEquals("my answer", 31626, allAmicableNums.sum())
    }

}