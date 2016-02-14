package euler03x

import euler00x.isPalindrome

/**
 * Created by joeyt on 2/13/16.
 */
object Euler036 {
    private val copyPasta = """
Double-base palindromes
Problem 36
The decimal number, 585 = 1001001001 2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
"""
    private val initialThoughts = """
    
"""

    fun Int.isDoublePalindrome(): Boolean {
        // from euler04
        // if not in palindrome in base 10, just stop
        if (!this.isPalindrome()) return false
        val binary = Integer.toString(this, 2)
        val charArray = binary.toCharArray()
        var a = 0
        var z = charArray.lastIndex
        while (a < z) {
            if (charArray[a] != charArray[z]) return false
            a++
            z--
        }
        return true
    }


    val doublePalindromes by lazy {
        (1..1000000).filter { it.isDoublePalindrome() }
    }

}