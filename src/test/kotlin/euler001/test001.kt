package euler001

import org.junit.Assert
import org.junit.Test

class Euler001 {

    // first implementation
    //      fun Int.isMultiple3or5(): Boolean = (this % 3 == 0) || (this % 5 == 0)
    // will return true for 0

    // Is 0 a natural number?
    @Test fun check0() {
        Assert.assertEquals("0 is not a multiple", false, 0.isMultiple3or5())
    }
    @Test fun check1to5() {
        Assert.assertEquals("1 is not a multiple", false, 1.isMultiple3or5())
        Assert.assertEquals("2 is not a multiple", false, 2.isMultiple3or5())
        Assert.assertEquals("3 is a multiple", true, 3.isMultiple3or5())
        Assert.assertEquals("4 is not a multiple", false, 4.isMultiple3or5())
        Assert.assertEquals("5 is a multiple", true, 5.isMultiple3or5())
    }
}

