package euler03x


import common.PrimeV1
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/15/16.
 */
class Euler037Test {
    @Test
    fun example() {
        //3797
        Assert.assertTrue("3797 is truncatable", Euler037.isTruncatablePrime(3797))

        Assert.assertTrue("2 prime", PrimeV1.isPrime(2))
        Assert.assertTrue("3 prime", PrimeV1.isPrime(3))
        Assert.assertTrue("23 prime", PrimeV1.isPrime(23))
        Assert.assertTrue("23 truncatable", Euler037.isTruncatablePrime(23))

    }

    @Test
    fun answer() {
        Assert.assertEquals("the 11 primes", 11, Euler037.truncatablePrimes.size)
        val expected = listOf(23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397)
        Assert.assertEquals("the 11 primes", expected, Euler037.truncatablePrimes)
        Assert.assertEquals("my answer", 748317, Euler037.answer())
    }

}