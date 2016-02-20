package euler04x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/20/16.
 */
class Euler040Test {
    @Test
    fun checkDemo() {
        println("champ(1,10)="+Euler040.champernowne.substring(1..10))

        Assert.assertEquals("d(12) == 1", 1, Euler040.d(12))
        Assert.assertEquals("d(11) == 0", 0, Euler040.d(11))
    }

    @Test
    fun answer() {
        Assert.assertEquals("my answer", 210, Euler040.answer())
    }

}