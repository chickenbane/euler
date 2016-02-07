package euler02x

import euler01x.Euler015
import java.util.*

/**
 * Created by joeyt on 1/25/16.
 */
object Euler024 {
    private val copyPasta = """
Lexicographic permutations
Problem 24
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.

The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
"""
    private val initialThoughts = """
time to learn some good stats

10! = 3 628 800 = 3.6M

32-bit int size = 2.1B

so the millionth permutation should start with a 3 since it's about a 1/3rd through (1M/3.6M)

0... 9! = 362880
1... 9! = 362880 + 362880 = 725760
2...      362880 + 362880 = 725760  // actually it will start with a 2
20... 8! = 40320 + 725760 = 766080
21... 8! = 40320 + 766080 = 806400
22... 8! = 40320 + 806400 = 846720
23... 8! = 40320 + 846720 = 887040
24... 8! = 40320 + 887040 = 927360
25... 8! = 40320 + 927360 = 967680  // start with 26

9! = 362880
1M / 362880 = 2.8

1M - (2*9!) = 1M - 725760 = 274240
8! = 40320
274240 / 4030 = 6.8

1M - 967680 = 32320
7! = 5040
32320 / 5040 = 6.4, 5040 * 6 = 30240

260... start index = 967680
266... start index = 967680 + 30240 = 997920

6! = 720
1M - 997920 = 2080, 2080 / 720 = 2.9, 720 * 2 = 1440

2660... start index = 997920
2662... start index = 997920 + 1440 = 999360

5! = 120
1M - 999360 = 640, 640 / 120 = 5.3, 120 * 5 = 600

26625... start index = 999360 + 600 = 999960

40 left, 4! = 24, 40 / 24 = 1.6
26625 1... = 999960 + 24 = 999984

16 left, 3! = 6, 16 / 6 = 2 with 4 left
26625 12... = 999984 + 12 = 999996

26625 120

oh whoops, reusing my digits.  think i got the formula down

"""

    val mil = 1000000
    val digits = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    val answer by lazy {
        val dst = ArrayList<Int>()
        val src = digits.toCollection(arrayListOf<Int>())
        var end = mil
        while (src.isNotEmpty()) {
            println("src=$src")
            println("dst=$dst")
            val factorial = Euler015.factorial(src.size).toInt()
            val index = end / factorial
            println("factorial ${src.size}! = $factorial")
            println("index=$index end=$end")

            //require(index < src.size)
            dst.add(src[index])
            src.removeAt(index)
            end = end - (factorial * index)
        }
        dst
    }

    private val wiki = """
https://en.wikipedia.org/wiki/Permutation#Algorithms_to_generate_permutations

The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.

1) Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
2) Find the largest index l greater than k such that a[k] < a[l].
3) Swap the value of a[k] with that of a[l].
4) Reverse the sequence from a[k + 1] up to and including the final element a[n].

For example, given the sequence [1, 2, 3, 4] which starts in a weakly increasing order, and given that the index is zero-based, the steps are as follows:

1) Index k = 2, because 3 is placed at an index that satisfies condition of being the largest index that is still less than a[k + 1] which is 4.
2) Index l = 3, because 4 is the only value in the sequence that is greater than 3 in order to satisfy the condition a[k] < a[l].
3) The values of a[2] and a[3] are swapped to form the new sequence [1,2,4,3].
4) The sequence after k-index a[2] to the final element is reversed. Because only one value lies after this index (the 3), the sequence remains unchanged in this instance.
Thus the lexicographic successor of the initial state is permuted: [1,2,4,3].

Following this algorithm, the next lexicographic permutation will be [1,3,2,4],
and the 24th permutation will be [4,3,2,1] at which point a[k] < a[k + 1] does not exist,
indicating that this is the last permutation.
    """

    // updates the array in place
    // returns false when array unchanged and there are no more permutations
    // returns true when this method can be called again to get the next permutation
    fun nextLexPermutation(seq: IntArray): Boolean {
        if (seq.isEmpty()) {
            return false
        }
        var k = -1
        var l = -1
        for (i in 0..seq.lastIndex - 1) {
            if (seq[i] < seq[i + 1]) {
                k = i
            }
            if (k != -1 && seq[k] < seq[i + 1]) {
                l = i + 1
            }
        }
        if (k == -1) {
            return false
        }
        seq.swap(k, l)
        var rev = k + 1
        var top = seq.lastIndex
        while(rev < top) {
            seq.swap(rev, top)
            rev += 1
            top -= 1
        }
        return true
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}