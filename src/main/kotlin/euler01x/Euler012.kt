package euler01x

import java.util.*

/**
 * Created by joeyt on 1/2/16.
 */
object Euler012 {
    private val copyPasta = """
Highly divisible triangular number
Problem 12
The sequence of triangle numbers is generated by adding the natural numbers.
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
"""
    private val initialThoughts = """

1. write a triangle number generator
2. write a divisor algorithm
3. brute force

"""

    fun triangleNum(num: Int): Int {
        require(num > 0)
        return (1..num).sum()
    }

    fun divisors(num: Int): Set<Int> {
        require(num > 0)
        val s = HashSet<Int>()
        for (i in 1..num) {
            if (num % i == 0) {
                s.add(i)
            }
        }
        return s
    }

    val divisors_answer = 500

    // i=11984 tri=71814120 set.size=256
    fun answer(): Int {
        var i = 11984
        var max = 256
        while(true) {
            val tri = triangleNum(i)
            val set = divisors(tri)
            val size = set.size
            if (size > divisors_answer) {
                println("triangleNum($i) = $tri")
                println("divisors($tri) = $set")
                return tri
            }
            max = if (size > max) size else max
            println("i=$i tri=$tri set.size=${set.size} max=$max")
            i += 1
        }
    }
}