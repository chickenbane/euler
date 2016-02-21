package common

import euler01x.Euler015
import euler02x.Euler024
import euler03x.Euler033.Rational
import euler03x.Euler038
import euler04x.Euler041
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Created by joeyt on 2/8/16.
 */
object Numbers {

    // from 30 to finally make this helper function
    // after 8, 16 char->int doesn't do what you want, must go char->string->int
    fun str2intArray(str: String) = str.toCharArray().map { it.toString().toInt() }.toIntArray()

    // perhaps a funny method, but useful
    fun int2intArray(i: Int) = str2intArray(i.toString())

    fun intArray2int(arr: IntArray) = arr.joinToString("").toInt()

    // from 24 and wikipedia
    fun nextLexPermutation(ia: IntArray): Boolean = Euler024.nextLexPermutation(ia)

    // rewritten because BigInt makes more sense
    // from euler015
    fun factorial(x: Int): BigInteger = (x downTo 1L).map { BigInteger.valueOf(it) }.fold(BigInteger.ONE) { acc, n -> acc * n }

    fun permutations(total: Int, items: Int): BigDecimal = Euler015.permutations(total, items)
    fun combinations(total: Int, items: Int): BigDecimal = Euler015.combinations(total, items)

    fun rational(num: Int, den: Int): Rational = Rational(num, den)

    // from euler038, 32, 41
    fun isPandigital(num: String): Boolean = Euler041.isPandigital(num)



}