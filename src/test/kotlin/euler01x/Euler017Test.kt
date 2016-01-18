package euler01x


import euler01x.Euler017.countLetters
import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/18/16.
 */
class Euler017Test {
    @Test
    fun checkSize() {
        Assert.assertEquals("array should be 1001 in size", 1001, Euler017.words.size)
    }

    @Test
    fun checkFirstFive() {
        // If the numbers 1 to 5 are written out in words: one, two, three, four, five, then
        // there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
        val firstFive = listOf("one", "two", "three", "four", "five")
        val actualFive = Euler017.words.subList(1, 6)
        Assert.assertEquals("first 5 words", firstFive, actualFive)
        Assert.assertEquals("first 5 = 19 letters", 19, actualFive.map { it.countLetters() }.sum())
    }

    @Test
    fun checkDemo() {
        // For example, 342 (three hundred and forty-two) contains 23 letters
        val e342 = "three hundred and forty-two"
        val a342 = Euler017.words[342]
        Assert.assertEquals("342", e342, a342)
        Assert.assertEquals("342 = 23 letters", 23, a342.countLetters())

        // 115 (one hundred and fifteen) contains 20 letters
        val e115 = "one hundred and fifteen"
        val a115 = Euler017.words[115]
        Assert.assertEquals("115", e115, a115)
        Assert.assertEquals("115 = 20 letters", 20, a115.countLetters())
    }

    @Test
    fun findAnswer() {
        // 1-99
        val first100 = Euler017.words.subList(0, 100)
        val first100letters = first100.map { it.countLetters() }.sum()
        println("first100=$first100letters")
        // 100-199
        val second100 = Euler017.words.subList(100, 200)
        val second100letters = second100.map { it.countLetters() }.sum()
        println("second100=$second100letters")
        // 200-299 should be the same as 100-199 since "one" and "two" are same number of letters
        val third100 = Euler017.words.subList(200, 300).map { it.countLetters() }.sum()
        println("third100=$third100")

        Assert.assertEquals("my answer", 21124, Euler017.words.map { it.countLetters() }.sum())
    }

}