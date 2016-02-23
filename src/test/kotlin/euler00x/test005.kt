package euler00x

import common.PrimeV1
import org.junit.Assert
import org.junit.Test

class Euler005 {
    //2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    @Test fun testDemo() {
        Assert.assertEquals("2520 for the first 10", 2520, smallestMultiple(10))
    }

    @Test fun test1to10() {
        Assert.assertEquals("smallestMultiple(1) = 1", 1, smallestMultiple(1))
        Assert.assertEquals("smallestMultiple(2) = 2", 2, smallestMultiple(2))
        Assert.assertEquals("smallestMultiple(3) = 6", 6, smallestMultiple(3))
        Assert.assertEquals("smallestMultiple(4) = 12", 12, smallestMultiple(4))
        Assert.assertEquals("smallestMultiple(5) = 60", 60, smallestMultiple(5))
        Assert.assertEquals("smallestMultiple(6) = 60", 60, smallestMultiple(6))
        Assert.assertEquals("smallestMultiple(7) = 420", 420, smallestMultiple(7))
        Assert.assertEquals("smallestMultiple(8) = 840", 840, smallestMultiple(8))
        Assert.assertEquals("smallestMultiple(9) = 2520", 2520, smallestMultiple(9))
    }

    @Test
    fun testFactorize12() {
        // factorize finds all prime factors of a number.  so, for 12 = 4 * 3 = 2 * 2 * 3 = listOf(2, 2, 3)
        val expected = listOf(2, 2, 3)
        val actual = PrimeV1.factorize(12)
        Assert.assertEquals("factors of 12", expected, actual)

        // so, to find prime factors of 12, do Prime.factorize(12).toSet()
        val expectedPrimeFactors = setOf(2, 3)
        val actualPrimeFactors = PrimeV1.factorize(12).toSet()
        Assert.assertEquals("prime factors of 12", expectedPrimeFactors, actualPrimeFactors)
    }
}
