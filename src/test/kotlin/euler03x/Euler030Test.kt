package euler03x


import common.Numbers
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/8/16.
 */
class Euler030Test {
    @Test
    fun str2intArray() {
        val arr359 = Numbers.str2intArray("359")
        Assert.assertEquals("359 should have 3 elements", 3, arr359.size)
        Assert.assertArrayEquals("359", intArrayOf(3,5,9), arr359)

        val arr0 = Numbers.str2intArray("00")
        Assert.assertEquals("00 should have 2 elements", 2, arr0.size)
        Assert.assertArrayEquals("0", intArrayOf(0, 0), arr0)

    }

    @Test(expected = NumberFormatException::class)
    fun noNegatives() {
        Numbers.str2intArray("-1")
    }

    @Test(expected = NumberFormatException::class)
    fun noDecimals() {
        Numbers.str2intArray(".1")
    }

    @Test
    fun int2intArray() {
        val arr359 = Numbers.int2intArray(359)
        Assert.assertEquals("359 should have 3 elements", 3, arr359.size)
        Assert.assertArrayEquals("359", intArrayOf(3,5,9), arr359)
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 443839, Euler030.answer())
    }

}