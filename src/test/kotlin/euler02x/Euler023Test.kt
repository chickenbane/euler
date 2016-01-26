package euler02x


import euler02x.Euler023.PerfectNumberType.*
import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by joeyt on 1/24/16.
 */
class Euler023Test {
    @Test
    fun testCalcNumberType() {
        // For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
        // A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
        // As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16
        // saying calcPerfectNumberType(0) == DEFICIENT just to make this array, would rather not start at 1 so I can go calcPerfectNumberType[28] == calcPerfectNumber(28)
        val actual: List<Euler023.PerfectNumberType> = (0..28).toList().map { if (it == 0) DEFICIENT else Euler023.calcPerfectNumberType(it) }
        Assert.assertEquals("28 is a perfect number", PERFECT, actual[28])
        Assert.assertEquals("12 is a abundant number", ABUNDANT, actual[12])

        val first12 = actual.subList(0, 11)
        Assert.assertTrue("first 12 should have no abundants", first12.all { it != ABUNDANT} )
    }

    @Test
    fun testNumToType() {
        Assert.assertEquals("28 is a perfect number", PERFECT, Euler023.numToType[28])
        Assert.assertEquals("12 is a abundant number", ABUNDANT, Euler023.numToType[12])
    }

    //@Test
    fun checkDemo() {
        // -1 because the array has a zero index set to DEFICIENT
        val counts = hashMapOf(ABUNDANT to 0, DEFICIENT to -1, PERFECT to 0)
        val abundants = ArrayList<Int>(6965)
        for ((i, t) in Euler023.numToType.withIndex()) {
            counts[t] = counts[t]!! + 1
            if (t == ABUNDANT) {
                abundants.add(i)
            }
        }
        println("my counts=$counts")  // my counts={ABUNDANT=6965, PERFECT=4, DEFICIENT=21154}

        // ~7000^2 is manageable.  brute force this

        val abundantSums = HashSet<Int>()
        for (a in abundants) {
            for (b in abundants) {
                abundantSums.add(a+b)
            }
        }
        println("abundantSums.size=${abundantSums.size}")
    }

    @Test
    fun answer() {
        // Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
        val nonAbundantSums: List<Int> = (1..Euler023.top).toList().filter { !Euler023.abundantSums.contains(it) }

        println("nonAbundantSums.size=${nonAbundantSums.size} sum=${nonAbundantSums.sum()}")
        Assert.assertEquals("my answer", 4179871, nonAbundantSums.sum())
    }
}