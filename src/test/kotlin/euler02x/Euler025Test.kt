package euler02x


import org.junit.Assert
import org.junit.Test
import java.math.BigInteger

/**
 * Created by joeyt on 2/2/16.
 */
class Euler025Test {
    @Test
    fun example() {
//        F1 = 1
//        F2 = 1
//        F3 = 2
//        F4 = 3
//        F5 = 5
//        F6 = 8
//        F7 = 13
//        F8 = 21
//        F9 = 34
//        F10 = 55
//        F11 = 89
//        F12 = 144
//        The 12th term, F12, is the first term to contain three digits.

        Assert.assertEquals("f(6) = 8", 8, Euler025.bigFib(6).toInt())
        Assert.assertEquals("f(9) = 34", 34, Euler025.bigFib(9).toInt())
        Assert.assertEquals("f(12) = 144", 144, Euler025.bigFib(12).toInt())

        Assert.assertEquals("1 = 1 digit", 1, Euler025.countDigits(BigInteger.valueOf(1)))
        Assert.assertEquals("16 = 2 digits", 2, Euler025.countDigits(BigInteger.valueOf(16)))
        Assert.assertEquals("10000 = 5 digits", 5, Euler025.countDigits(BigInteger.valueOf(10000)))

        Assert.assertEquals("f(7) == first with 2", 7, Euler025.firstTermWithDigits(2))
        Assert.assertEquals("f(12) == first with 3", 12, Euler025.firstTermWithDigits(3))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 4782, Euler025.firstTermWithDigits(1000))

    }

}