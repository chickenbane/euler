package euler04x


import common.Prime
import common.PrimeV1
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/21/16.
 */
class Euler047Test {
    val noInts: List<Int> = emptyList()

    @Test
    fun oldFactorize() {
        Assert.assertEquals("factors of 12", listOf(2, 2, 3), PrimeV1.factorize(12))
        Assert.assertEquals("factors of 5", listOf(5), PrimeV1.factorize(5))
        Assert.assertEquals("factors of 2", listOf(2), PrimeV1.factorize(2))
        Assert.assertEquals("factors of 1", noInts, PrimeV1.factorize(1))
        // PrimeV1.factorize < 1 -> exception
    }

    @Test
    fun newFactorize() {
        Assert.assertEquals("factors of 12", listOf(2, 2, 3), Prime.factorize(12))
        Assert.assertEquals("factors of 5", listOf(5), Prime.factorize(5))
        Assert.assertEquals("factors of 2", listOf(2), Prime.factorize(2))
        Assert.assertEquals("factors of 1", noInts, Prime.factorize(1))
        Assert.assertEquals("factors of 0", noInts, Prime.factorize(0))
        Assert.assertEquals("factors of -2", noInts, Prime.factorize(-2))
    }

    @Test
    fun testLoadPrimes() {
        val start = System.currentTimeMillis()
        Assert.assertEquals("first primes has 78498", 78498, Prime.FIRST_PRIMES.size)
        Assert.assertEquals("first prime is 2", Prime.TWO, Prime.FIRST_PRIMES.first())
        val stop = System.currentTimeMillis()
        println("time to load FIRST_PRIMES = ${stop-start}ms")
    }


    @Test
    fun factorizePrimes() {
        val expected: List<Prime?> = listOf(2, 2, 3).map { Prime.of(it) }
        Assert.assertEquals("factors of 12", expected, Prime.factorizeToPrimes(12))
    }

    @Test
    fun testDistinctPrimeFactors() {
        Assert.assertEquals("first 2 start at 14", 14, Euler047.firstTwo())
        Assert.assertEquals("first 3 start at 644", 644, Euler047.firstThree())
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 134043, Euler047.firstFour())
    }

}