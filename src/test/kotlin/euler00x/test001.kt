package euler00x

import org.junit.Assert
import org.junit.Test

class Euler001 {

    // first implementation
    //      fun Int.isMultiple3or5(): Boolean = (this % 3 == 0) || (this % 5 == 0)
    // will return true for 0

    // Is 0 a natural number?
    @Test fun check0() {
        Assert.assertFalse("0 is not a multiple", 0.isMultiple3or5())
    }
    @Test fun check1to5() {
        Assert.assertFalse("1 is not a multiple", 1.isMultiple3or5())
        Assert.assertFalse("2 is not a multiple", 2.isMultiple3or5())
        Assert.assertTrue("3 is a multiple", 3.isMultiple3or5())
        Assert.assertFalse("4 is not a multiple", 4.isMultiple3or5())
        Assert.assertTrue("5 is a multiple", 5.isMultiple3or5())
    }

    // If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

    @Test fun checkDemo() {
        val first10 = naturalsBelow(10)
        Assert.assertEquals("naturalsBelow(10) should have 10 elements", 10, first10.size)

        val multiples = first10.filter { it.isMultiple3or5() }
        Assert.assertEquals("3, 5, 6, 9 are the multiples", listOf(3, 5, 6, 9), multiples)

        Assert.assertEquals("sum correct", 23, multiples.sum())
    }
}

