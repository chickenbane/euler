package euler03x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 2/9/16.
 */
class Euler032Test {
    @Test
    fun checkDemo() {
        Assert.assertTrue("39 × 186 = 7254", Euler032.isPandigital(39, 186))
    }

    @Test
    fun bruteForce() {
        val answer = Euler032.bruteForce()
        println("my answer (${answer.size}) = $answer")

        Assert.assertEquals("my answer", 45228, Euler032.answer())

        // A lesson to be learned here:
        // Even though I was unsure how to start, once I had an answer I became overly confident
        // I initially thought only 2-digit * 3-digit would work, forgetting 1-digit * 4-digits
    }
}