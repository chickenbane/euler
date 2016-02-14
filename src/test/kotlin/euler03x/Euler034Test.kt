package euler03x


import common.Numbers
import org.junit.Assert
import org.junit.Test
import java.math.BigInteger
import java.util.*

/**
 * Created by joeyt on 2/13/16.
 */
class Euler034Test {
    @Test
    fun checkDemo() {
//        145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
        Assert.assertEquals("actual should be expected", BigInteger.valueOf(145), Euler034.sumDigitFactorial(145))

        Assert.assertEquals("0! = 1", BigInteger.ONE, Numbers.factorial(0))
    }


    //@Test
    fun findCurious() {

        val precalc = (3..1000000) to listOf(BigInteger.valueOf(145), BigInteger.valueOf(40585))

        val curious = ArrayList<Int>().apply {
            for (i in 1000000..10000000) {
                val bi = BigInteger.valueOf(i.toLong())
                val sum = Euler034.sumDigitFactorial(i)
                if (bi == sum) {
                    add(i)
                }
            }
        }

        println("curious = ${precalc.second + curious}")
    }

    @Test
    fun answer() {
        // well that was anticlimactic
        val curious = listOf(BigInteger.valueOf(145), BigInteger.valueOf(40585))
        Assert.assertEquals("my answer", 40730, curious.reduce { x, y -> x + y }.toInt())
    }

}