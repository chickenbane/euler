package euler04x


import common.Prime
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/20/16.
 */
class Euler041Test {
    @Test
    fun checkDemo() {
        Assert.assertEquals("Digits[0] == empty", emptySet<Int>(), Euler041.Digits[0])
        // 2143 is a 4-digit pandigital and is also prime
        Assert.assertTrue("2143 pandigital", Euler041.isPandigital("2143"))
        Assert.assertTrue("2143 prime", Prime.isPrime(2143))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 7652413, Euler041.answer())
    }

}