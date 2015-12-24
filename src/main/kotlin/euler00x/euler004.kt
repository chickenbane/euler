package euler00x

import java.util.*

// Largest palindrome product
// Problem 4
// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
// Find the largest palindrome made from the product of two 3-digit numbers.

fun Int.isPalindrome(): Boolean {
    val s = this.toString()
    var a = 0
    var z = s.lastIndex
    while (z > a) {
        if (s[a] != s[z]) return false
        a += 1
        z -= 1
    }
    return true
}

// Brute force the first 100*100
fun bruteForceEuler004(): List<Int> {
    val products = ArrayList<Int>(100*100)
    for (i in 900..999) {
        for (j in 900..999) {
            products.add(i*j)
        }
    }
    return products.distinct().filter { it.isPalindrome() }.sortedDescending()
}


fun main(args: Array<String>) {
    println("euler004 palindronmes: ${bruteForceEuler004()}")
}