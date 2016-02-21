package euler04x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/21/16.
 */
class Euler045Test {
    @Test
    fun checkDemo() {
        println("Euler045.common=" + Euler045.common)
        Assert.assertEquals("my answer", 1533776805L, Euler045.common.max())
    }

}