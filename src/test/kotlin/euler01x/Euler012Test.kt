package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/4/16.
 */
class Euler012Test {

    //So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
    // 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
    @Test
    fun checkTriangle() {
        Assert.assertEquals("triangleNum(1)", 1, Euler012.triangleNum(1))
        Assert.assertEquals("triangleNum(2)", 3, Euler012.triangleNum(2))
        Assert.assertEquals("triangleNum(3)", 6, Euler012.triangleNum(3))
        Assert.assertEquals("triangleNum(4)", 10, Euler012.triangleNum(4))
        Assert.assertEquals("triangleNum(5)", 15, Euler012.triangleNum(5))
        Assert.assertEquals("triangleNum(6)", 21, Euler012.triangleNum(6))
        Assert.assertEquals("triangleNum(7)", 28, Euler012.triangleNum(7))
        Assert.assertEquals("triangleNum(8)", 36, Euler012.triangleNum(8))
        Assert.assertEquals("triangleNum(9)", 45, Euler012.triangleNum(9))
        Assert.assertEquals("triangleNum(10)", 55, Euler012.triangleNum(10))
    }

    //    1: 1
    //    3: 1,3
    //    6: 1,2,3,6
    //    10: 1,2,5,10
    //    15: 1,3,5,15
    //    21: 1,3,7,21
    //    28: 1,2,4,7,14,28
    @Test
    fun checkDivisors() {
        Assert.assertEquals("divisorTriangle(1)", setOf(1), Euler012.divisors(Euler012.triangleNum(1)))
        Assert.assertEquals("divisorTriangle(2)", setOf(1,3), Euler012.divisors(Euler012.triangleNum(2)))
        Assert.assertEquals("divisorTriangle(3)", setOf(1,2,3,6), Euler012.divisors(Euler012.triangleNum(3)))
        Assert.assertEquals("divisorTriangle(4)", setOf(1,2,5,10), Euler012.divisors(Euler012.triangleNum(4)))
        Assert.assertEquals("divisorTriangle(5)", setOf(1,3,5,15), Euler012.divisors(Euler012.triangleNum(5)))
        Assert.assertEquals("divisorTriangle(6)", setOf(1,3,7,21), Euler012.divisors(Euler012.triangleNum(6)))
        Assert.assertEquals("divisorTriangle(7)", setOf(1,2,4,7,14,28), Euler012.divisors(Euler012.triangleNum(7)))
    }

    @Test
    fun answer() {
        Assert.assertEquals(76576500, Euler012.answer())
    }

}