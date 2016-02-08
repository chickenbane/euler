package euler02x

import java.math.BigDecimal
import java.math.MathContext
import java.util.*

/**
 * Created by joeyt on 2/2/16.
 */
object Euler026 {
    private val copyPasta = """
Reciprocal cycles
Problem 26
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
"""
    private val initialThoughts = """
    i think i can solve this with math, or i can solve it by just pattern matching the string
    // no math pls, i wanna write code!
"""


    val rationals: Map<Int, UnitFraction> by lazy {
        val map = HashMap<Int, UnitFraction>()
        for (i in 1..1000) {
            val uf = UnitFraction(i)
            if (!uf.irrational) {
                map.put(i, uf)
            }
        }
        Collections.unmodifiableMap(map)
    }

    // d is the denominator for 1/d
    data class UnitFraction(val d: Int) {
        // had to play with the precision of mc, since the ability of the findPrefixAndSuffix() method
        // depends on how many repeating matches a substring can be found, which depends on
        // how big the decimal representation we can get a string of
        // the answer for this problem was a pattern that was 984 digits long
        // therefore, the string generated had to be much greater than that to see the pattern matches
        private val mc = MathContext(5000)
        private val bdd = BigDecimal(d)

        val bd = BigDecimal.ONE.divide(bdd, mc)

        // good to read substringAfter(), missingDelimiter value is smart, but perhaps surprising
        // if no match is found, returns original string
        // in this case, that is okay
        // also remove the last character of string so we don't have to worry about rounding
        //val str = bd.toPlainString().substringAfter("0.").run { substring(0, lastIndex) }
        val str = bd.toPlainString().substringAfter("0.").dropLast(1)

        // sentinel value if irrational
        private val irrSent = "irr"

        // want early return
        private fun findPrefixAndSuffix(): Pair<String, String> {
            for (i in str.indices) {
                // note the weird use of str.length
                // this is because the 2nd arg to .substring() could be str.length
                // and str.length = 1 + str.lastIndex
                for (j in (i+1)..str.length) {

                    val subLen = j - i
                    val endingLen = str.length - i

                    if (endingLen > subLen * 3) {  // at least 3 matches, depends on mc precision
                        val sub = str.substring(i, j)
                        val ending = str.substring(i)

                        // repeating true if ending is sub repeating
                        val repeating = (0..ending.lastIndex-subLen step subLen).all {
                            val chunk = ending.substring(it, it + subLen)
                            chunk == sub
                        }

                        if (repeating) {
                            val prefix = str.substring(0, i)
                            return prefix to sub
                        }
                    }
                }
            }
            return irrSent to "0"
        }

        // want evaluate-once, use twice (prefix, suffix)
        private val prefixAndSuffix by lazy { findPrefixAndSuffix() }

        val prefix by lazy { prefixAndSuffix.first }
        // the repeating part
        val suffix by lazy { prefixAndSuffix.second }

        val irrational by lazy { prefix == irrSent }

        val prettyString by lazy { "$prefix($suffix)" }
    }


    // quick diversion: learning about Collections.binarySearch()
    // returns (-(insertion point) - 1)
    //  The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key, or list.size() if all elements in the list are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
}