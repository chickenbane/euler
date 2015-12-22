package euler001

import org.junit.Assert
import org.junit.Test
import euler001.isMultiple3or5

class Euler001 {
    @Test fun testIs3or5Multiple() {
        Assert.assertEquals("please work.", true, true)
        herro("kotlin")

    }

    @Test fun needNamedTest() {
        Assert.assertEquals("test name", true, 3.isMultiple3or5())
    }
}

