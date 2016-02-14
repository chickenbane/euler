package euler03x


import euler03x.Euler036.isDoublePalindrome
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/13/16.
 */
class Euler036Test {
    @Test
    fun checkDemo() {
//        The decimal number, 585 = 1001001001 2 (binary), is palindromic in both bases.
        Assert.assertTrue("585 is double", 585.isDoublePalindrome())
        Assert.assertFalse("584 is not", 584.isDoublePalindrome())
        Assert.assertFalse("484 is not", 484.isDoublePalindrome())

    }

    @Test
    fun answer() {
        println("list of doubles: ${Euler036.doublePalindromes}")
        Assert.assertEquals("my answer", 872187, Euler036.doublePalindromes.sum())
    }

}