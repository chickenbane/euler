package euler02x


import common.PrimeV1
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/7/16.
 */
class Euler027Test {
    @Test
    fun checkIsPrime() {
        Assert.assertFalse("1 is not prime", PrimeV1.isPrime(1))
        Assert.assertTrue("2 is prime", PrimeV1.isPrime(2))
        Assert.assertTrue("3 is prime", PrimeV1.isPrime(3))
        Assert.assertFalse("4 is not prime", PrimeV1.isPrime(4))
    }

    @Test
    fun example() {
        // n² + n + 41 has 40 primes
        val ex1: (Int) -> Int = { n -> (n * n) + n + 41 }
        Assert.assertEquals("ex1 = 40", 40, Euler027.numConsecutivePrimes(ex1))

//        n² − 79n + 1601 was discovered, which produces 80 primes
        val ex2: (Int) -> Int = { n -> (n * n) - (79 * n) + 1601 }
        Assert.assertEquals("ex2 = 80", 80, Euler027.numConsecutivePrimes(ex2))
    }

    @Test
    fun checkQuadFun() {
        // should be same as example
        val ex1 = Euler027.quadraticFun(1, 41)
        Assert.assertEquals("ex1 = 40", 40, Euler027.numConsecutivePrimes(ex1))

        val ex2 = Euler027.quadraticFun(-79, 1601)
        Assert.assertEquals("ex2 = 80", 80, Euler027.numConsecutivePrimes(ex2))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", -59231, Euler027.answer())
    }

}