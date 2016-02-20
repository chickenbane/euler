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
    private val initialThoughts = """
   I should write a stars and bars class for reuse.  unlike the lexiographic sequence thing this one should probably be recursive?
"""

    class StarsAndBars(val total: Int, val buckets: Int) : Iterator<IntArray> {
        // a write-only IntArray returned by next, though this is still not thread safe
        // callers shouldn't mess with it, but even if they did this class will never read from it
        private val array by lazy { IntArray(buckets) }

        private val list = LinkedList<Int>()
        private val next = LinkedList<Int>().apply {
            for (i in array.indices) {
                val amt = if (i == array.lastIndex) total - buckets + 1 else 1
                add(amt)
            }
            require(sum() == total && size == buckets)
        }

        override fun hasNext(): Boolean {
            throw UnsupportedOperationException()
        }

        // would probably be safer to just copy the array
        override fun next(): IntArray {
            require(list.isEmpty() && next.size == buckets)
            while (list.sum() < total) {
                val amt = if (list.size == buckets - 1) // last bucket
                    total - list.sum()
                else
                    1
                list.add(amt)
            }

            require(list.size == buckets)
            for (i in array.indices) {
                val v = list.remove()
                array[i] = v
                next.add(v)
            }
            require(list.isEmpty() && next.size == buckets)

            return array
            // throw NoSuchElementException
        }
    }

    // advantages over Triple<Int, Int, Int>
    // 1: Don't want to type Triple<Int, Int, Int>
    // 2: lol, while "avoiding" writing that I've written it twice
    // 3: a, b, c and much easier to unpack
    // 4: it's fine.
    data class Tri(val a: Int, val b: Int, val c: Int) {
        // god i love the pythagorean theorem
        val isRightTriangle: Boolean = (a*a + b*b) == c*c
        val perimeter = a + b + c
    }

    fun findSolutions(perimeter: Int): List<Tri> {
        val list = ArrayList<Tri>()
        for (a in 1..perimeter) {
            for (b in 1..perimeter) {
                for (c in 1..perimeter) {
                    val t = Tri(a, b, c)
                    if (t.perimeter == perimeter && t.isRightTriangle) {
                        list.add(t)
                    }
                }
            }
        }
        return list
    }

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

    // this brute force is doing worse than normal brute force.  i'll reach p = 1000, but this will run much longer than 1 minute
    // fine, no objects.
    // also, defect, a tri(3,4,5) should be the same as tri(4,3,5)
    fun findSolutions2(perimeter: Int): Set<Triple<Int, Int, Int>> {
        val set = LinkedHashSet<Triple<Int, Int, Int>>()
        for (a in 1..perimeter - 1) {
            for (b in 1..perimeter - 1) {
                val c = perimeter - a - b
                val right = (a*a + b*b) == c*c
                if (!right) continue
                val abc = Triple(a, b, c)
                val bac = Triple(b, a, c)
                if (abc !in set && bac !in set) set.add(abc)
            }
        }
        return set
    }
}