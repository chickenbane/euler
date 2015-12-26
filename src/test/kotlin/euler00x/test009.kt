package euler00x

import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 12/25/15.
 */
class Euler009Test {
    @Test fun checkAnswer() {
        val triplet = euler009.findPythagoreanTriplet(1000)
        val a = triplet.first
        val b = triplet.second
        val c = triplet.third
        Assert.assertEquals("a+b+c = 1000", 1000, a+b+c)
        Assert.assertEquals("a^2 + a^b = c^2", c*c, (a*a) + (b*b))
    }

}