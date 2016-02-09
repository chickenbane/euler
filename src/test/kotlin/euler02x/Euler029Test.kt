package euler02x


import org.junit.Assert
import org.junit.Test
import java.math.BigInteger
import java.util.*

/**
 * Created by joeyt on 2/8/16.
 */
class Euler029Test {
    @Test
    fun checkDemo() {
        val set = HashSet<BigInteger>()
        for (a in 2..5) {
            for (b in 2..5) {
                set.add(Euler029.kapow(a, b))
            }
        }
        Assert.assertEquals("2..5 is 15 terms", 15, set.size)
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 100, Euler029.answer())
    }
}