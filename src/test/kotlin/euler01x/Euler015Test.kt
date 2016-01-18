package euler01x


import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

/**
 * Created by joeyt on 1/15/16.
 */
class Euler015Test {
    @Test
    fun checkFactorial() {
        Assert.assertEquals("3! = 6", 6, Euler015.factorial(3))
        Assert.assertEquals("4! = 24", 24, Euler015.factorial(4))
    }

    @Test
    fun checkAnswer() {
        fun f(x: Int) = Euler015.factorialBd(x)
        val f40: BigDecimal = Euler015.factorialBd(40)
        val f20: BigDecimal = Euler015.factorialBd(20)
        val uno = f40 / f20
        val dos = uno / f20
        println("f40=$f40 f20=$f20 uno=$uno dos=$dos")
        Assert.assertEquals("(40!/20!)/20!=137 846 528 820", BigDecimal(137846528820), dos)
    }

    // f40=-70609262346240000 f20=2432902008176640000 uno=0 dos=0
    // oh you son of a bitch I overflowed a long

    @Test
    fun checkPermsAndCombos() {
        // pick a team of 3 from a group of 10
        // choose 3 desserts from a menu of 10
        Assert.assertEquals("C(10,3)=120", BigDecimal(120), Euler015.combinations(10, 3))
        Assert.assertEquals("C(10,7)=120", BigDecimal(120), Euler015.combinations(10, 7))

        // pick president, vp, waterboy from 10
        // choose 3 desserts, in order in a menu of 10
        Assert.assertEquals("P(10,3)=720", BigDecimal(720), Euler015.permutations(10, 3))
        Assert.assertNotSame("P(10,7)!=720", BigDecimal(720), Euler015.permutations(10, 7))
    }
}