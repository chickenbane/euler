package euler02x

import java.io.File
import java.util.*

/**
 * Created by joeyt on 1/24/16.
 */
object Euler022 {
    private val copyPasta = """
Names scores
Problem 22
Using names.txt (right click and 'Save Link/Target As...'),
a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order.
Then working out the alphabetical value for each name,
multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order,
COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
"""
    private val initialThoughts = """
leverage problem 067, where I found the most straight-forward way to parse a file
    write fun parseNames(inputFilename: String): List<String>

then, sort in alphabetic order

write fun alphabeticalValue(name: String): Int
write val letterValue: Map<Char, Int>
write fun nameScore(name: String): Int
"""

    fun parseNames(inputFilename: String): List<String> {
        val text: String = File(inputFilename).readText()
        val quotedNames: List<String> = text.split(",")
        return quotedNames.map { it.trim('"') }
    }

    val firstNames by lazy { parseNames("src/main/resources/p022_names.txt") }

    val firstNamesSorted: List<String> by lazy { firstNames.sorted() }

    // alphabet[0,6] = charArrayOf(a, b, c, d, e, f)
    val alphabet: CharArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    // letterValue[a] == 1, letterValue[A] == 1
    // letterValue[y] == 25, letterValue[Y] == 25
    // letterValue.size == 26+26 == 52
    val letterValue: Map<Char, Int> by lazy {
        val map = HashMap<Char, Int>()
        for((i, c) in alphabet.withIndex()) {
            val letterVal = i+1
            map.put(c, letterVal)
            map.put(c.toUpperCase(), letterVal)
        }
        map
    }


    // Interesting note, had to convert from List<Int?> to List<Int> via filterNotNull()
    fun alphabeticalValue(name: String): Int = name.toCharArray().map { letterValue[it] }.filterNotNull().sum()

    // AARON, ABBEY, ABBIE, ABBY, ABDUL, ABE, ABEL, ABIGAIL, ABRAHAM, ABRAM
    // first ten names sorted in alphabetic order
    // COLIN [...] is the 938th name in the list.
    // namePos[AARON] == 1 namePos[ABRAM] == 10 namePos[COLIN] == 938
    val namePos: Map<String, Int> by lazy {
        val map = HashMap<String, Int>()
        for ((i, name) in firstNamesSorted.withIndex()) {
            map.put(name, i+1)
        }
        map
    }

    // nameScore(COLIN) would obtain a score of 938 × 53 = 49714.
    fun nameScore(name: String): Int {
        val namePos: Int = namePos[name]!!
        val alphabeticValue: Int = alphabeticalValue(name)
        return namePos * alphabeticValue
    }

}