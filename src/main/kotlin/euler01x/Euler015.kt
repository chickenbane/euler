package euler01x

import java.math.BigDecimal
import java.util.*

/**
 * Created by joeyt on 1/10/16.
 */
object Euler015 {
    private val copyPasta = """
Lattice paths
Problem 15
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

{image}
TL = (0, 0)
BR = (2, 2)
(0, 0) (1, 0) (2, 0)
(0, 1) (1, 1) (2, 1)
(0, 2) (1, 2) (2, 2)

1: (0, 0) (1, 0) (2, 0) (2, 1) (2, 2)
2: (0, 0) (1, 0) (1, 1) (2, 1) (2, 2)
3: (0, 0) (1, 0) (1, 1) (1, 2) (2, 2)
4: (0, 0) (0, 1) (1, 1) (2, 1) (2, 2)
5: (0, 0) (0, 1) (1, 1) (1, 2) (2, 2)
6: (0, 0) (0, 1) (0, 2) (1, 2) (2, 2)
{/image}

How many such routes are there through a 20×20 grid?
"""
    private val initialThoughts = """
try mapping 2d board to an array
0 1 2
3 4 5
6 7 8

2x2 = 9 points
0 1
2 3

1x1 = 4 points
3x3 = 16 points

nxnGrid(1) = 4
nxnGrid(2) = 9
nxnGrid(3) = 16
fun nxnGrid(n) = (n+1)^2

same 6 routes using array indicies
1: 0 1 2 5 8
2: 0 1 4 5 8
3: 0 1 4 7 8
4: 0 3 4 5 8
5: 0 3 4 7 8
6: 0 3 6 7 8

same 6 routes using directions (r, d)
1: r r d d
2: r d r d
3: r d d r
4: d r r d
5: d r d r
6: d d r r


Actually think my first represntation, the Pair(x, y) is easiest to generalize, because
basically AxA grids just go from (0, 0) to (A, A), and each move just increments (x, y) by 1

...

in a nxn grid, you need to go r n times and d n times
moves: (2n) so for 2x2 = 4 moves, 20x20 = 40 moves
so another way is how many permutations of [rd]{40}

1x1 grid
1: (0, 0) (0, 1) (1, 1)
2: (0, 0) (1, 0) (1, 1)

1: d r
2: r d

3x3 grid, 6 moves
r r r d d d
r r d d d r
r r d r d d
r r d d r d
r d r d d r
r d r r d d
r d r d r d
r d d d r r
r d d r d r
r d d r r d
d d d r r r
d d r r r d
d d r r d r
d d r d r r
d r d d r r
d r r d r d
d r r d d r
d r r r d d
d r d r d r
d r d r r d

20 total (2 x (6+3+1)

moves for 1x1 = 2 (2x1)
moves for 2x2 = 6 (2x3)
moves for 3x3 = 20 (2x(6+3+1)))

ugh... that moment when you know the answer to this is something easy if you remembered school.
onward, brute force!
ah, data structure!

"""
    class PathPos(val square: Int, val pos: Pair<Int, Int>) {
        val x = pos.first
        val y = pos.second

        val right = PathPos(square, (x + 1) to y)
        val down = PathPos(square, x to (y + 1))

        fun canRight(): Boolean = right.x <= square
        fun canDown(): Boolean = right.y <= square
    }

    fun calcAllPaths(square: Int): Set<List<PathPos>> {
        val paths = HashSet<List<PathPos>>()
        val start = PathPos(square, 0 to 0)
        val list = ArrayList<PathPos>()
        list.add(start)
        paths.add(list)
        return paths
    }

    fun calcAllRoutes(square: Int): Set<List<Pair<Int, Int>>> {
        require(square > 0)
        val grid = Grid(square)
        val start = 0 to 0
        val end = square to square
        return setOf()
    }


    // assume first and second value won't be below zero
    fun Pair<Int, Int>.vaildInSquare(square: Int): Boolean = first <= square && second <= square

    fun Pair<Int, Int>.nextMoves(square: Int): List<Pair<Int, Int>> {
        val right = (first + 1) to second
        val down = first to (second + 1)
        return listOf<Pair<Int, Int>>(right, down).filter { it.vaildInSquare(square) }
    }

    class Move(start: Pair<Int, Int>, end: Pair<Int, Int>)

    class Grid(val square: Int) {
        fun isValid(pos: Pair<Int, Int>): Boolean = 0 <= pos.first && pos.first <= square &&
                0 <= pos.second && pos.second <= square
    }

    fun factorial(x: Int): Long {
        return (x downTo 1).toList().map { it.toLong() }.fold(1L) { acc, n -> acc * n }
    }

    fun factorialBd(x: Int): BigDecimal {
        return (x downTo 1).toList().map { BigDecimal(it) }.fold(BigDecimal.ONE) { acc, n -> acc * n }
    }

    fun permutations(total: Int, items: Int): BigDecimal = factorialBd(total).divide(factorialBd(total-items))
    fun combinations(total: Int, items: Int): BigDecimal = permutations(total, items).divide(factorialBd(items))
}

// I admit defeat.
// http://betterexplained.com/articles/navigate-a-grid-using-combinations-and-permutations/
