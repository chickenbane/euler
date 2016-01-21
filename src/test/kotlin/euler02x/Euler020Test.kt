package euler02x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/21/16.
 */
class Euler020Test {
    @Test
    fun checkDemo() {
        // the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
        Assert.assertEquals("10! sum of digits", 27, Euler020.sumOfFactorial(10))

        // 4! = 24 = sum of digits = 6
        Assert.assertEquals("4! sum of digits", 6, Euler020.sumOfFactorial(4))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 648, Euler020.sumOfFactorial(100))
    }
}