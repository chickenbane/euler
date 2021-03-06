package euler04x

/**
 * Created by joeyt on 2/21/16.
 */
object Euler045 {
    private val copyPasta = """
Triangular, pentagonal, and hexagonal
Problem 45
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.

Find the next triangle number that is also pentagonal and hexagonal.
"""
    private val initialThoughts = """
    
"""

    fun triangle(n: Int): Long = n * (n + 1L) / 2L
    fun pentagonal(n: Int): Long = n * (3L * n - 1L) / 2L
    fun hexagonal(n: Int): Long = n * (2L * n - 1L)

    val BigN = 1000000
    val triArr by lazy { LongArray(BigN) { triangle(it)} }
    val tris by lazy { triArr.toSet() }
    val pents by lazy { LongArray(BigN) { pentagonal(it)}.toSet() }
    val hexs by lazy { LongArray(BigN) { hexagonal(it)}.toSet() }

    val common by lazy {
        tris.toHashSet().apply {
            retainAll(pents)
            retainAll(hexs)
        }
    }

}