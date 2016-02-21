package euler04x


import common.Letters
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/20/16.
 */
class Euler042Test {
    @Test
    fun t() {
        /*
        The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

        1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

        By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
        For example, the word value for SKY is 19 + 11 + 25 = 55 = t10
        */

        val expected = listOf(1, 3, 6, 10, 15, 21, 28, 36, 45, 55)
        val actual = (1..10).map { Euler042.t(it) }
        Assert.assertEquals("t(1) should be 1", 1, Euler042.t(1))
        Assert.assertEquals("t(4) should be 10", 10, Euler042.t(4))
        Assert.assertEquals("t(7) should be 28", 28, Euler042.t(7))
        Assert.assertEquals("first ten", expected, actual)
    }

    @Test
    fun letterPos() {
        Assert.assertEquals("S = 19", 19, Letters.alphaPos('S'))
        Assert.assertEquals("K = 11", 11, Letters.alphaPos('K'))
        Assert.assertEquals("Y = 25", 25, Letters.alphaPos('Y'))
    }

    @Test
    fun wordVal() {
        Assert.assertEquals("sky = 55", 55, Euler042.wordVal("sky"))
        Assert.assertEquals("SKY = 55", 55, Euler042.wordVal("SKY"))
    }

    @Test
    fun triangleWord() {
        Assert.assertTrue("sky", Euler042.isTriangleWord("sky"))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 162, Euler042.answer)
    }

}