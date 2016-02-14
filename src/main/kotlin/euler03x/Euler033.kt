package euler03x

import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/9/16.
 */
object Euler033 {
    private val copyPasta = """
Digit cancelling fractions
Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it
may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
"""
    private val initialThoughts = """
    
"""

    data class Rational(val num: Int, val den: Int) {
        val numFactors = if (num == 0) emptyList() else Prime.factorize(num)
        val denFactors = if (den == 0) emptyList() else Prime.factorize(den)

        val reducible = numFactors.any { it in denFactors }

        fun reduce(): Rational {
            require(reducible)
            val firstFactor = numFactors.filter { it in denFactors }.first()
            var next = Rational(num/firstFactor, den/firstFactor)
            do {
                if (next.reducible) {
                    next = next.reduce()
                }
            } while (next.reducible)
            return next
        }

        val reduced: Rational = if (reducible) reduce() else this

        fun identical(other: Rational): Boolean = this.reduced == other.reduced

        val str = "$num/$den"

        operator fun times(other: Rational): Rational = Rational(reduced.num * other.reduced.num, reduced.den * other.reduced.den).reduced

        companion object {
            val ONE = Rational(1, 1)
        }
    }

    fun Rational.isCurious(): Boolean {
        val numArr = num.toString().toCharArray()
        val denArr = den.toString().toCharArray()
        val denSet = denArr.toSet()
        for (numChar in numArr) {
            if (numChar in denSet) {
                val nextList = numArr.toMutableList()
                nextList.remove(numChar)
                val nextNum = nextList.joinToString(separator = "").toInt()
                val denList = denArr.toMutableList()
                denList.remove(numChar)
                val nextDen = denList.joinToString(separator = "").toInt()
                val nextRat = Rational(nextNum, nextDen)
                if (this.identical(nextRat)) {
                    return true
                }
            }
        }
        return false
    }

    // 2 digits
    // < 1 (num < den)
    // "trivial"  $num % 10 == 0
    fun findTwoDigitCuriousNums(): List<Rational> {
        return ArrayList<Rational>().apply {
            for (num in 10..99) {
                for (den in 10..99) {
                    if (num < den) {
                        val rat = Rational(num, den)
                        if (rat.isCurious() && num % 10 != 0) {
                            add(rat)
                        }
                    }
                }
            }
        }
    }

    val curiousNums by lazy { findTwoDigitCuriousNums() }

    // If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
    val answer by lazy {
        require(curiousNums.size == 4)
        // limited usage of operator overloading
        val product = curiousNums.fold(Rational.ONE) { acc, n -> acc * n}
        product.den
    }
}
