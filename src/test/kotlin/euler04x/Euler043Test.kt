package euler04x


import common.Numbers
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/20/16.
 */
class Euler043Test {
    @Test
    fun example() {
        val ex = "1406357289"
        val exArr = Numbers.str2intArray(ex)
        Assert.assertTrue("actual should be expected", Euler043.isPandigital09(ex))
        Assert.assertTrue("has property", Euler043.subDiv(exArr))
    }

    @Test
    fun answer() {
        val answer = Euler043.answer()
        println("answer = $answer")
        Assert.assertEquals("my answer", 16695334890, answer.sum())
    }

}