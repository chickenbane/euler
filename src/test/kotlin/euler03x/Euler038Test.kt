package euler03x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/16/16.
 */
class Euler038Test {

    @Test
    fun isStringPandigital() {
        // 192384576
        Assert.assertTrue("192384576 is pandigital", Euler038.isPandigital("192384576"))

        // 918273645
        Assert.assertTrue("918273645 is pandigital", Euler038.isPandigital("918273645"))

        Assert.assertFalse("123 is not", Euler038.isPandigital("123"))
        Assert.assertFalse("123123123 is not", Euler038.isPandigital("123123123"))
    }

    @Test
    fun examples() {
        val ex1 = (1..3).map { it * 192 }
        Assert.assertTrue("192 from 1-3", Euler038.isPandigital(ex1))

        val ex2 = (1..5).map { it * 9 }
        Assert.assertTrue("9 from 1-5", Euler038.isPandigital(ex2))

        val ex1neg = (1..3).map { it * 193 }
        Assert.assertFalse("193 from 1-3", Euler038.isPandigital(ex1neg))

        val ex2neg = (1..4).map { it * 9 }
        Assert.assertFalse("9 from 1-4", Euler038.isPandigital(ex2neg))
    }

    @Test
    fun products() {
        val ex1 = Euler038.products(192)
        Assert.assertEquals("192 had 3 elements", 3, ex1.size)
        // 192 × 1 = 192
        // 192 × 2 = 384
        // 192 × 3 = 576
        Assert.assertEquals("192 list", listOf(192, 384, 576), ex1)

        val ex2 = Euler038.products(9)
        Assert.assertEquals("9 had 5 elements", 5, ex2.size)
        Assert.assertEquals("9 list", listOf(9, 18, 27, 36, 45), ex2)
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 932718654, Euler038.bruteForce())
    }

}