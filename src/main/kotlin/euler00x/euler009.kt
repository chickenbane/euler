package euler00x

/**
 * Boom.  This is the first exercise I used "new file template".  That whole experience seems like a buggy area of IntelliJ.  Had to restart.
 *
 * Created by joeyt on 12/25/15.
 */
object euler009 {
    val copyPasta = """
Special Pythagorean triplet
Problem 9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
"""
    val initialThoughts = """
Brute force it, iterate through every combo where a + b + c = 1000, find which are pythag.

"""


    // assumes "exactly one" lol, just returns the first it finds
    fun findPythagoreanTriplet(target: Int): Triple<Int, Int, Int> {
        for (a in 1..target) {
            for (b in 1..target) {
                val c = target - a - b
                val a2 = a * a
                val b2 = b * b
                val c2 = c * c
                if (a2 + b2 == c2) {
                    println("a=$a b=$b c=$c a^2=$a2 b^2=$b2 c^2=$c2 abc=${a*b*c}")
                    return Triple(a, b, c)
                }
            }
        }
        return Triple(0,0,0)
    }
}

fun main(args: Array<String>) {
    val triplet = euler009.findPythagoreanTriplet(1000)
    val answer = triplet.first * triplet.second * triplet.third
    println("my answer is $answer")
}