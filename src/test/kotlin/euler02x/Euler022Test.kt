package euler02x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/24/16.
 */
class Euler022Test {

    @Test
    fun testParsingTextFile() {
        // first five names in file = "MARY","PATRICIA","LINDA","BARBARA","ELIZABETH"
        val expected = listOf("MARY","PATRICIA","LINDA","BARBARA","ELIZABETH")
        Assert.assertEquals("first five names == listOf(MARY,PATRICIA,LINDA,BARBARA,ELIZABETH)", expected, Euler022.firstNames.subList(0, 5))
    }

    @Test
    fun testSortingNamesInAlphabeticOrder() {
        // AARON, ABBEY, ABBIE, ABBY, ABDUL, ABE, ABEL, ABIGAIL, ABRAHAM, ABRAM
        // first ten names sorted in alphabetic order
        val expected = listOf("AARON", "ABBEY", "ABBIE", "ABBY", "ABDUL", "ABE", "ABEL", "ABIGAIL", "ABRAHAM", "ABRAM")
        val first10NamesSorted = Euler022.firstNamesSorted.subList(0, 10)
        println("firstNamesSorted=$first10NamesSorted")
        Assert.assertEquals("first ten names == listOf()", expected, first10NamesSorted)

        // For example, when the list is sorted into alphabetical order,
        // COLIN [...] is the 938th name in the list.
        Assert.assertEquals("COLIN = 938th", "COLIN", Euler022.firstNamesSorted[937])

        // namePos[AARON] == 1 namePos[ABRAM] == 10 namePos[COLIN] == 938
        Assert.assertEquals("namePos[AARON] == 1", 1, Euler022.namePos["AARON"])
        Assert.assertEquals("namePos[ABRAM] == 10", 10, Euler022.namePos["ABRAM"])
        Assert.assertEquals("namePos[COLIN] == 938", 938, Euler022.namePos["COLIN"])
    }

    @Test
    fun testAlphabet() {
        // char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        val expected = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
        val actual = Euler022.alphabet.sliceArray(0..5)
        Assert.assertArrayEquals("alphabet[0,6] = charArrayOf(a, b, c, d, e, f)", expected, actual)
        // fyi, sliceArray(0..5) has size = 6
        Assert.assertEquals("sliceArray(0..5).size == 6", 6, actual.size)
    }

    @Test
    fun testLetterValue() {
        // letterValue[a] == 1, letterValue[A] == 1
        // letterValue[y] == 25, letterValue[Y] == 25
        // letterValue.size == 26+26 == 52
        Assert.assertEquals("letterValue[a] == 1", 1, Euler022.letterValue['a'])
        Assert.assertEquals("letterValue[A] == 1", 1, Euler022.letterValue['A'])
        Assert.assertEquals("letterValue[y] == 25", 25, Euler022.letterValue['y'])
        Assert.assertEquals("letterValue[Y] == 25", 25, Euler022.letterValue['Y'])
        Assert.assertEquals("letterValue.size == 26+26 == 52", 52, Euler022.letterValue.size)
    }

    @Test
    fun testAlphabeticValue() {
        // COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53
        Assert.assertEquals("COLIN = 53", 53, Euler022.alphabeticalValue("COLIN"))
        Assert.assertEquals("colin = 53", 53, Euler022.alphabeticalValue("colin"))

    }

    @Test
    fun testNameScore() {
        // nameScore(COLIN) would obtain a score of 938 × 53 = 49714.
        Assert.assertEquals("nameScore(COLIN) = 49714", 49714, Euler022.nameScore("COLIN"))
    }

    @Test
    fun answer() {
        // What is the total of all the name scores in the file?
        val actual = Euler022.firstNames.map { Euler022.nameScore(it) }.sum()
        Assert.assertEquals("my answer", 871198282, actual)
    }

}