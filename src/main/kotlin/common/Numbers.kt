package common

import euler02x.Euler024

/**
 * Created by joeyt on 2/8/16.
 */
object Numbers {

    // from 30 to finally make this helper function
    // after 8, 16 char->int doesn't do what you want, must go char->string->int
    fun str2intArray(str: String) = str.toCharArray().map { it.toString().toInt() }.toIntArray()

    // perhaps a funny method, but useful
    fun int2intArray(i: Int) = str2intArray(i.toString())

    // from 24 and wikipedia
    fun nextLexPermutation(ia: IntArray): Boolean = Euler024.nextLexPermutation(ia)
}