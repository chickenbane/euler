package euler03x

import java.util.*

/**
 * Created by joeyt on 2/15/16.
 */
object Euler038 {
    private val copyPasta = """
Pandigital multiples
Problem 38
Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
"""
    private val initialThoughts = """
    
"""

    val Digits = (1..9).toSet()

    fun isPandigital(str: String): Boolean {
        val list = str.toCharArray().map { it.toString().toInt() }
        return list.size == Digits.size && list.toSet() == Digits
    }
    fun isPandigital(list: List<Int>): Boolean = isPandigital(list.joinToString(""))

    fun products(x: Int): List<Int> {
        val list = ArrayList<Int>()
        var n = 1
        var len = 0
        do {
            val product = x * n
            list.add(product)
            len += product.toString().length
            n += 1
        } while (len < 9)
        return list
    }

    fun bruteForce(): Int {
        var max = 0
        for (i in 1..1000000) {
            val products = products(i)
            if (isPandigital(products)) {
                println("pandigital at i=$i")
                val num = products.joinToString("").toInt()
                if (num > max) {
                    println("old max = $max new = $num")
                    max = num
                }
            }
        }
        return max
    }

}