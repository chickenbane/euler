package euler04x

/**
 * Created by joeyt on 2/20/16.
 */
object Euler040 {
    private val copyPasta = """
Champernowne's constant
Problem 40
An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
"""
    private val initialThoughts = """
    what is this, a center for ants? if i only have to find out a million places, i'll just make a big string
"""
    val Ants = 1000000

    val champernowne by lazy {
        val sb = StringBuilder()
        var pos = 0  // start at zero so d[1] == 1
        while (sb.length < Ants + 1) {
            sb.append(pos)
            pos += 1
        }
        sb.toString()
    }

    fun d(n: Int): Int = champernowne[n].toString().toInt()

    fun answer(): Int = d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000)

}