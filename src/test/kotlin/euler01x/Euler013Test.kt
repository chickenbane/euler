package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/4/16.
 */
class Euler013Test {
    @Test
    fun checkDemo() {
        Assert.assertEquals("100 elements", 100, Euler013.numArray.size)
        Assert.assertTrue("all elements 50 digits", Euler013.numArray.all { it.toString().length == 50 })
    }

    @Test
    fun answer() {
        Assert.assertEquals("5537376230", Euler013.answer())
    }

}