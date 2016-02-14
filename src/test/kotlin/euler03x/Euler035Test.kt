package euler03x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/13/16.
 */
class Euler035Test {
    @Test
    fun rotation() {
        // The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
        val rotations: IntArray = Euler035.rotations(197)
        Assert.assertEquals("197 has 3 rotations", 3, rotations.size)

        val set = rotations.toSet()
        Assert.assertEquals("197 rotations", setOf(197, 971, 719), set)

    }

    @Test
    fun below100() {
        // There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
        val circulars = (2..100).filter { Euler035.isCircularPrime(it) }
        Assert.assertEquals("13 circulars < 100", 13, circulars.size)
    }

    @Test
    fun answer() {
        val circulars = (2..1000000).filter { Euler035.isCircularPrime(it) }
        Assert.assertEquals("my answer", 55, circulars.size)
    }

}