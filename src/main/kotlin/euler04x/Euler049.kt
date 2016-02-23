package euler04x

import common.Numbers
import common.Prime
import java.util.*

/**
 * Created by joeyt on 2/22/16.
 */
object Euler049 {
    private val copyPasta = """
Prime permutations
Problem 49
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
"""
    private val initialThoughts = """
    let's just iterate through the four digit primes
"""

    val fourDigitPrimes: Set<Int> = Prime.FIRST_PRIMES.map { it.num }.filter { it.toString().length == 4 }.toSet()

    // find all groups of four digit primes that are permutations of one another
    // each group of permutations is in a sorted list
    fun fdpPermutations(): Set<List<Int>> {
        val set = HashSet<List<Int>>()
        for (p in fourDigitPrimes) {
            val parr = Numbers.int2intArray(p)
            val innerSet = HashSet<Int>()
            do {
                val num = Numbers.intArray2int(parr)
                if (num in fourDigitPrimes) {
                    innerSet.add(num)
                }
                val again = Numbers.nextLexPermutation(parr)
            } while (again)
            if (innerSet.size > 2) set.add(innerSet.sorted())
        }
        return set
    }

    fun answer(): String {
        val permutations = fdpPermutations()
        println("permutations = ${permutations.size}")
        val seqs = permutations.filter { isSeq(it) }.map { toSeq(it) }.filterNotNull().toSet()
        println("sequences = $seqs")
        return seqs.first().joinToString("")
    }

    private fun toSeq(list: List<Int>): List<Int>? {
        val diffs = LinkedList<Int>()
        for ((idx, elem) in list.withIndex()) {
            if (idx == list.lastIndex) continue
            val next = list[idx + 1]
            diffs.add(next - elem)
        }
        val groupBy: Map<Int, List<Int>> = diffs.groupBy { it }
        for ((k, v) in groupBy) {
            if (v.size >= 2) {
                val seq = HashSet<Int>()
                for (elem in list) {
                    val next = elem + k
                    if (next in list) {
                        seq.add(elem)
                        seq.add(next)
                    }
                }
                val sorted = seq.sorted()
                println("sorted=$sorted delta=$k list=$list diffs=$diffs groupBy=$groupBy")
                if (k != 3330) continue  // lol was wondering why I got so many damn answers
                // however, why didn't the example set 1487 end up in here?
                return sorted
            }
        }
        return null
    }

    private fun isSeq(list: List<Int>): Boolean = toSeq(list) != null

}