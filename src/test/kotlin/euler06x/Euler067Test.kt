package euler06x


import euler01x.Euler018
import euler01x.Euler018Test
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/20/16.
 */
class Euler067Test {

    @Test
    fun checkParsing() {
        Assert.assertEquals("problem has 100 rows", 100, Euler067.problemArray.size)
        Assert.assertTrue("problem array is triangle array", Euler018Test.isTriangleArray(Euler067.problemArray))
        Assert.assertEquals("first is 59", 59, Euler067.problemArray[0][0])
        Assert.assertEquals("last in line 10 = 9", 9, Euler067.problemArray[9][9])
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 7273L, Euler018.findMaxSum(Euler067.problemArray))
    }

}