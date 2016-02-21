package euler04x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/21/16.
 */
class Euler044Test {
    @Test
    fun checkDemo() {
        val pairs = Euler044.pairs
        println("size=${pairs.size} pairs=$pairs")
        // I thought this would more than one solution
        Assert.assertEquals("pairs.size", 1, pairs.size)

        Assert.assertEquals("my answer", 5482660L, pairs.first().diff)
    }

}