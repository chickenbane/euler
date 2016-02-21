package euler04x

import common.Letters
import euler02x.Euler022
import java.util.*

/**
 * Created by joeyt on 2/20/16.
 */
object Euler042 {
    private val copyPasta = """
Coded triangle numbers
Problem 42
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
"""
    private val initialThoughts = """
    
"""
    fun parseFile(filename: String) = Euler022.parseNames(filename)

    val words: List<String> by lazy { parseFile("src/main/resources/p042_words.txt") }

    fun t(n: Int): Int = n * (n + 1) / 2  // ugh, have to do divide last

    fun wordVal(input: String): Int = input.map { Letters.alphaPos(it) }.sum()

    val triangleValues = HashSet<Int>()

    fun isTriangleWord(input: String): Boolean {
        val wordVal = wordVal(input)
        val max = triangleValues.max()
        if (max == null || max < wordVal) {
            var n = 1
            do {
                val curr = t(n)
                triangleValues.add(curr)
                n += 1
            } while (curr < wordVal)
        }
        return wordVal in triangleValues
    }

    val answer by lazy { words.filter { isTriangleWord(it)}.size }
}