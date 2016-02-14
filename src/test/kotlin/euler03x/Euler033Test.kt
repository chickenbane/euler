package euler03x


import euler03x.Euler033.isCurious
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/13/16.
 */
class Euler033Test {
    val ex1 = Euler033.Rational(49, 98)
    val fourEighths = Euler033.Rational(4, 8)
    val ex2 = Euler033.Rational(30, 50)
    val threeFifths = Euler033.Rational(3, 5)

    @Test
    fun identical() {
        // 49/98 = 4/8 is obtained by cancelling the 9s. lols
        Assert.assertTrue("49/98 == 4/8", ex1.identical(fourEighths))
        Assert.assertTrue("4/8 == 49/48", fourEighths.identical(ex1))

        // 30/50 = 3/5
        Assert.assertTrue("30/50 == 3/5", ex2.identical(threeFifths))
        Assert.assertTrue("3/5 == 30/50", threeFifths.identical(ex2))

        Assert.assertFalse("3/5 != 4/8", fourEighths.identical(threeFifths))
    }

    @Test
    fun curious() {
        Assert.assertTrue("ex1 is curious", ex1.isCurious())
        Assert.assertFalse("4/8 not curious", fourEighths.isCurious())
        Assert.assertTrue("ex2 is curious", ex2.isCurious())
        Assert.assertFalse("3/5 is not curious", threeFifths.isCurious())
    }

    @Test
    fun findCurious() {
        val nums = Euler033.findTwoDigitCuriousNums()
        println("nums = ${nums.map{ it.str }.joinToString()}")
        Assert.assertEquals("4 curious", 4, nums.size)
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 100, Euler033.answer)
    }

}