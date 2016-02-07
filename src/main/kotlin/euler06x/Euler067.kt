package euler06x

import java.io.File

/**
 * Created by joeyt on 1/20/16.
 */
object Euler067 {
    private val copyPasta = """
Maximum path sum II
Problem 67
By starting at the top of the triangle below and moving to adjacent numbers on the row below,
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'),
a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route
to solve this problem, as there are 2^99 altogether! If you could check one trillion (10^12) routes
every second it would take over twenty billion years to check them all. There is an efficient
algorithm to solve it. ;o)
"""
    private val initialThoughts = """
use the same solution as 18!
this space to do file io
"""

    fun fileTo2dArray(inputFilename: String): Array<IntArray> {
        val lines = File(inputFilename).readLines()
        val list = lines.filter { it.isNotBlank() }.toCollection(arrayListOf<String>())

        // ArrayList<String> to Array<IntArray>
        return Array(list.size) {
            list[it].split(' ').map { it.trim().toInt() }.toIntArray()
        }
    }

    val problemArray by lazy { fileTo2dArray("src/main/resources/p067_triangle.txt") }

}
