package euler01x

/**
 * Created by joeyt on 1/18/16.
 */
object Euler018 {
    private val copyPasta = """
Maximum path sum I
Problem 18
By starting at the top of the triangle below and moving to adjacent numbers on the row below,
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
"""
    private val initialThoughts = """
lol, I'm glad it's not problem 67 yet.

maybe go by each row and "reduce"?
   3
  7 4
 2 4 6
8 5 9 3

When you have the choice of parents, just choose max.  seems simple enough!
        3
     10  7
  12  14  13
20  19  23  16
at the end, just choose max.
"""

    // from problem 11
    fun stringTo2dArray(input: String): Array<IntArray> {
        // string to ArrayList<String>
        val list = input.lineSequence().filter { it.isNotBlank() }.toCollection(arrayListOf<String>())

        // ArrayList<String> to Array<IntArray>
        return Array(list.size) {
            list[it].split(' ').map { it.trim().toInt() }.toIntArray()
        }
    }

    fun findMaxSum(input: Array<IntArray>): Long {
        val lastRow = calcLastRow(input)
        return lastRow.max()!!
    }

    fun calcLastRow(input: Array<IntArray>): LongArray {
        var prevRowSums = LongArray(0)
        var nextRowSums = LongArray(0)

        for ((row, arr) in input.withIndex()) {
            require(arr.size == row+1)  // i am triangle
            nextRowSums = LongArray(arr.size)
            for ((i, v) in arr.withIndex()) {
                nextRowSums[i] = v.toLong() + maxPrev(i, prevRowSums)
            }
            prevRowSums = nextRowSums
        }

        return nextRowSums
    }

    // return the max of prevRowSums[i] and prevRowSums[i-1]
    // taking care of the details.
    private fun maxPrev(i: Int, prevRowSums: LongArray): Long {
        val first = safeGet(i, prevRowSums)
        val second = safeGet(i-1, prevRowSums)
        return if (first > second) first else second
    }

    private fun safeGet(i: Int, prevRowSums: LongArray): Long =
        if (i >= 0 && i < prevRowSums.size) prevRowSums[i] else 0



}