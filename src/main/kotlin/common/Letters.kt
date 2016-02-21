package common

import euler02x.Euler022
import java.util.*

/**
 * Created by joeyt on 2/20/16.
 */
object Letters {
    // alphabet[0,6] = charArrayOf(a, b, c, d, e, f)
    val alphabet: CharArray = Euler022.alphabet

    // not the same as Euler022, want this to correspond with alphabet (0-based)
    // letterIndex[a] == 0, letterIndex[A] == 0
    // letterIndex[y] == 24, letterIndex[Y] == 24
    // letterIndex.size == 26+26 == 52
    val letterIndex: Map<Char, Int> by lazy {
        val map = HashMap<Char, Int>()
        for ((i, c) in alphabet.withIndex()) {
            val letterVal = i
            map.put(c, letterVal)
            map.put(c.toUpperCase(), letterVal)
        }
        map
    }

    // alphaPos(a) == 1
    // alphaPos(b) == 2
    // alphaPos(c) == 3
    fun alphaPos(c: Char): Int = letterIndex[c]!! + 1
}