package euler00x

import org.junit.Assert
import org.junit.Test
import java.util.*

class Euler002 {

    // 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    @Test fun first10() {
        val first10 = listOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)

        val calculated10 = ArrayList<Int>()
        for (i in 1..10) {
            calculated10.add(fib(i))
        }

        Assert.assertEquals("first 10 in fib", first10, calculated10)
    }

    // fib(33)=5702887
    @Test fun fib33() {
        Assert.assertEquals("fib(33)=5702887", 5702887, fib(33))
    }

    @Test fun fib32() {
        Assert.assertEquals("fib(32)=3524578", 3524578, fib(32))
    }
}

