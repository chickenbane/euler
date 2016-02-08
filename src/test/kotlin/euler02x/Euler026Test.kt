package euler02x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/2/16.
 */
class Euler026Test {
    @Test
    fun checkDemo() {
        var max = 0
        var key = 0
        Euler026.rationals.forEach {
            val uf = it.value
            val pf = uf.prettyString
            if (pf.length > max) {
                max = pf.length
                key = it.key
                println("key=$key len=${pf.length} val=$pf")
            }
        }
        Assert.assertEquals("my answer", 983, key)
    }

}