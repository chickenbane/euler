package euler02x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/8/16.
 */
class Euler028Test {
    @Test
    fun checkDemo() {
        val spiral3 = Euler028.NumberSpiral(3)
        val spiral5 = Euler028.NumberSpiral(5)
        val spiral7 = Euler028.NumberSpiral(7)
        println(spiral3.toString())
        println(spiral5.toString())
        println(spiral7.toString())
        Assert.assertEquals("spiral 3 sum = 25", 25, spiral3.diagonalSum)
        Assert.assertEquals("spiral 5 sum = 101", 101, spiral5.diagonalSum)
        Assert.assertEquals("spiral 7 sum = 261", 261, spiral7.diagonalSum)
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 669171001, Euler028.NumberSpiral(1001).diagonalSum)
    }

}