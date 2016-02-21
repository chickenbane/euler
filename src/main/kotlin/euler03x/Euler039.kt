package euler03x

import java.util.*

/**
 * Created by joeyt on 2/16/16.
 */
object Euler039 {
    private val copyPasta = """
Integer right triangles
Problem 39
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
"""

    fun answer(): Int {
        var max = 0
        var maxNum = 0
        for (p in 1..1000) {
            val sols = findSolutions2(p)
            if (sols.size > max) {
                max = sols.size
                maxNum = p
                println("max = $max at $p sols=$sols")
            }
        }
        return maxNum
    }

    data class RightTriangle(val a: Int, val b: Int, val c: Int)

    fun findSolutions2(perimeter: Int): Set<RightTriangle> {

        val set = object : LinkedHashSet<RightTriangle>() {
            // overriding contains in this way means that solutions returned will allow
            // RightTriangle(4, 3, 5) in setOf(RightTriangle(3,4,5)
            override fun contains(element: RightTriangle): Boolean {
                if (super.contains(element)) return true
                val bac = RightTriangle(element.b, element.a, element.c)
                return super.contains(bac)
            }
        }
        for (a in 1..perimeter - 1) {
            for (b in 1..perimeter - 1) {
                val c = perimeter - a - b
                val right = (a*a + b*b) == c*c
                if (!right) continue
                val abc = RightTriangle(a, b, c)
                // this works because we rewrote contains() above
                if (abc !in set) set.add(RightTriangle(a, b, c))
                // however, the check must still be present.  the set will still add RightTriangle(b,a,c)
                // guessing i need to override hashCode() as well for that.
            }
        }
        return set
    }
}