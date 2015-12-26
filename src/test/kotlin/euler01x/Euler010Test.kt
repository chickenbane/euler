package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 12/26/15.
 */
class Euler010Test {
    //    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    @Test fun checkDemo() {
        val primesLt10 = Euler010.findPrimesLessThan(10)
        Assert.assertEquals("primes less than 10", listOf(2,3,5,7), primesLt10)
        Assert.assertEquals("sum is 17", 17, primesLt10.sum())
    }

}