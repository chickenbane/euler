package euler04x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/22/16.
 */
class Euler048Test {

    @Test
    fun answer() {
        Assert.assertEquals("10 chars", 10, Euler048.answer.length)
        Assert.assertEquals("my answer", "9110846700", Euler048.answer)
    }

}