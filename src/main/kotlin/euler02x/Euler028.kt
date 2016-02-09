package euler02x

/**
 * Created by joeyt on 2/7/16.
 */
object Euler028 {
    private val copyPasta = """
Number spiral diagonals
Problem 28
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
"""
    private val initialThoughts = """

xy 0  1  2  3  4
0 21 22 23 24 25
1 20  7  8  9 10
2 19  6  1  2 11
3 18  5  4  3 12
4 17 16 15 14 13

    n = 5     n = 3
    1 = 2, 2  1, 1
    2 = 2, 3  1, 2
    3 = 3, 3  2, 2
    4 = 3, 2  2, 1
    5 = 3, 1  2, 0
    6 = 2, 1  1, 0
    7 = 1, 1  0, 0
    8 = 1, 2  0, 1
    9 = 1, 3  0, 2
    10  1, 4
    11  2 ,4
    12  3, 4
    13  4, 4
    14  4, 3
    15  4, 2

    rdlur
    11222

    n = 3
    rdlluurr
    n = 5
    rdlluurrrdddlllluuuurrrr

    rdlluurr
    rdddlllluuuurrrr

    rdlur
    11222
    13444

    n = 3
    7 8 9 6 1 2 5 4 3
    0 1 2 3 4 5 6 7 8
    n = 5
    21 22 23 24 25 20 7 8 9 10 19 6  1  2  11 18 5  4  3  12 17 16 15 14 13
    0  1  2  3  4  5  6 7 8 9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24

    ugh just making a number spiral is turning into an annoying task.
"""

    val Right = 0 to 1
    val Left = 0 to -1
    val Down = 1 to 0
    val Up = -1 to 0
    val Clockwise = listOf(Right, Down, Left, Up)
    fun nextDir(curr: Pair<Int, Int>): Pair<Int, Int> {
        val idx = Clockwise.indexOf(curr)
        require(idx != -1)
        return if (idx == Clockwise.lastIndex) Clockwise[0] else Clockwise[idx + 1]
    }

    class NumberSpiral(val n: Int) {
        // start array with all values = -1
        val array = Array(n) { IntArray(n) { -1 } }

        init {
            require(n % 2 != 0) // this number spiral won't work with even numbers

            var pos: Pair<Int, Int> = n/2 to n/2  // start at the middle
            var count = 1
            var currDir = Right

            do {
                array[pos.first][pos.second] = count
                pos = pos.first + currDir.first to pos.second + currDir.second
                val nextDir = nextDir(currDir)
                val nextX = pos.first + nextDir.first
                val nextY = pos.second + nextDir.second
                // if next position is valid and vacant
                if (nextX < n && nextY < n && array[nextX][nextY] == -1) {
                    currDir = nextDir
                }
                count += 1
            } while (count <= n*n)
        }

        override fun toString(): String {
            val sb = StringBuilder("\n")
            for (y in array.indices) {
                sb.append(array[y].joinToString(separator = " ")).append("\n")
            }
            return sb.toString()
        }

        val diagonalSum by lazy {
            var sum = 0
            for (i in 0..n-1) {
                sum += array[i][i] + array[i][n - 1 - i]
            }
            // the middle number (1) is counted twice above, so
            sum - array[n / 2][n / 2]
        }
    }

}