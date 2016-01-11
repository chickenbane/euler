package euler01x

import java.util.*

/**
 * Created by joeyt on 1/10/16.
 */
object Euler014 {
    private val copyPasta = """
Longest Collatz sequence
Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.

Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
"""
    private val initialThoughts = """
idk how to not brute force this

lol classic before and after.  statement above is before statement.  of course got an oom

observation, we can keep ending sequences, once it has been found, we can stop.
"""

    fun nextCollatz(n: Int): Int = if (n % 2 == 0) n/2 else (3*n)+1

    fun collatzSeq(start: Int): ArrayList<Int> {
        var c = start
        val seq = ArrayList<Int>().apply { add(start) }
        while (c != 1) {
            val next = nextCollatz(c)
            seq.add(next)
            c = next
        }
        return seq
    }

    fun collatzSeqLen(start: Int): Int {
        var c = start
        var seqSize = 1
        while (c != 1) {
            val next = nextCollatz(c)
            seqSize += 1
            c = next
        }
        return seqSize
    }

    fun nextCollatz(n: Long): Long = if (n % 2L == 0L) n/2L else (3L*n)+1L

    fun collatzSeqLen(start: Long): Int {
        var c = start
        var seqSize = 1
        while (c != 1L) {
            val next:Long = nextCollatz(c)
            seqSize += 1
            c = next
        }
        return seqSize
    }

}

