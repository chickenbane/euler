package euler05x

import common.Numbers

/**
 * Created by joeyt on 2/25/16.
 */
object Euler052 {
    private val copyPasta = """
Permuted multiples
Problem 52
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
"""

    fun num2set(input: Int) = Numbers.int2intArray(input).toHashSet()

    fun answer(): Int {
        var i = 1
        while (true) {
            val sets = (1..6).map { num2set(it*i) }
            val first = sets.first()
            val count = sets.count { first.containsAll(it) }
            if (count > 3) {
                println("count=$count for i=$i sets=$sets")
            }
            if (sets.all { first.containsAll(it)}) {
                return i
            }
            i += 1
        }
    }


}