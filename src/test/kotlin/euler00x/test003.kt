package euler00x

import org.junit.Assert
import org.junit.Test

class Euler003 {
    //The prime factors of 13195 are 5, 7, 13 and 29.
    @Test fun testDemo() {
        val demoFactors = listOf(5, 7, 13, 29)
        val calculatedFactors = findFactors(13195)

        println("demoFactors = $demoFactors")
        println("calculatedFactors = $calculatedFactors")

        // list equality ain't what it used to be
        //Assert.assertEquals("factor list should match", demoFactors, calculatedFactors)

        // why isn't this working
        //Assert.assertTrue("should contain correct factors", (calculatedFactors as Collection<Any?>).containsAll(demoFactors))

        val expected = demoFactors.map { it.toInt() }
        val actual = calculatedFactors.map { it.toInt() }
        Assert.assertEquals("int lists should match", expected, actual)

        // lesson learned: it was the Int list types
    }
}
