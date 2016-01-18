package euler01x

/**
 * Created by joeyt on 1/16/16.
 */
object Euler017 {
    private val copyPasta = """
Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then
there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and"
when writing out numbers is in compliance with British usage.
"""
    private val initialThoughts = """
an arraylist(1000) doesn't sound unreasonable, right?
"""
    private val tens = listOf(
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety")

    val words = arrayListOf(
            "", // index zero
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen").apply {

        ensureCapacity(1001)  // want index [1000]

        // add 20-99
        for (t in tens) {
            add(t)
            for (i in 1..9) {
                add("$t-${this[i]}")
            }
        }
        // add 100-999
        for (h in 1..9) {
            val hHundred = "${this[h]} hundred"
            add(hHundred)
            for (i in 1..99) {
                add("$hHundred and ${this[i]}")
            }
        }

        add("one thousand")
    }

    // Note, don't generalize this, counting on the fact they're all lower lol
    fun String.countLetters(): Int = toArrayList().filter { it.isLowerCase() }.size
}