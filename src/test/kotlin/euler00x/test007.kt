package euler00x

import org.junit.Assert
import org.junit.Test

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
class Euler007Test {
    @Test fun testDemo() {
        Assert.assertEquals("findPrime(1) = 2", 2, findPrime(1))
        Assert.assertEquals("findPrime(2) = 3", 3, findPrime(2))
        Assert.assertEquals("findPrime(3) = 5", 5, findPrime(3))
        Assert.assertEquals("findPrime(4) = 7", 7, findPrime(4))
        Assert.assertEquals("findPrime(5) = 11", 11, findPrime(5))
        Assert.assertEquals("findPrime(6) = 13", 13, findPrime(6))
    }
}