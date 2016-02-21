package euler03x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/20/16.
 */
class Euler039Test {
    @Test
    fun example() {
        /*
        If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

        {20,48,52}, {24,45,51}, {30,40,50}
        */
        val ex = Euler039.findSolutions2(120)
        Assert.assertEquals("3 solutions for p = 120", 3, ex.size)

        val tri345 = Euler039.RightTriangle(30, 40, 50)
        Assert.assertTrue("{30, 40, 50} a solution for p = 120", tri345 in ex)

        val tri435 = Euler039.RightTriangle(40, 30, 50)
        Assert.assertTrue("{40, 30, 50} a solution for p = 120", tri435 in ex)

    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 840, Euler039.answer())
    }

}