package euler02x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/26/16.
 */
class Euler024Test {
    @Test
    fun checkDemo() {
        val example = intArrayOf(0, 1, 2)
        var count = 0
        do {
            val again = Euler024.nextLexPermutation(example)
            count += 1
        } while (again)
        Assert.assertEquals("6 permutations", 6, count)
        Assert.assertArrayEquals("last permutation", intArrayOf(2, 1, 0), example)
    }

    @Test
    fun answer() {
        val input = IntArray(10) { it }
        var count = 1 // off by one error: count the initial input as first permutation
        do {
            Euler024.nextLexPermutation(input)
            count += 1
        } while (count < 1000000)
        val arrstr = input.joinToString(separator = "")
        Assert.assertEquals("my answer", "2783915460", arrstr)
    }
}