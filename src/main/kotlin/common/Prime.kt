package common

import java.util.*

/**
 * Created by joeyt on 2/22/16.
 */
data class Prime private constructor(val num: Int) {

    companion object {
        // the first prime
        val TWO = Prime(2)

        fun isPrime(x: Int): Boolean {
            if (x <= 1) return false
            if (x == 2) return true
            val sqrt: Double = Math.sqrt(x.toDouble())
            val ceil = Math.ceil(sqrt).toInt()
            return (2..ceil).none { x % it == 0 }
        }

        // prime factory, and since Prime has a private constructor the only way to get one!
        fun of(num: Int): Prime? = if (isPrime(num)) Prime(num) else null

        fun factorizeToPrimes(num: Int): List<Prime> {
            return factorize(num).map { Prime.of(it) ?: throw IllegalStateException("factorized non-prime $it") }
        }

        // factorize(12) == listOf(2, 2, 3)
        // factorize(5) == listOf(5)
        // factorize(2) == listOf(2)
        // factorize(1) == emptyList()
        // factorize(0) == emptyList()
        // factorize(-2) == emptyList()
        fun factorize(x: Int): List<Int> {
            if (x <= 1) return emptyList()
            val list = LinkedList<Int>()
            fun reduce(y: Int): Int? {
                if (y == 1) return null
                val sqrt = Math.ceil(Math.sqrt(y.toDouble())).toInt()
                for (i in 2..sqrt) {
                    if (y % i == 0) {
                        list.add(i)
                        return y / i
                    }
                }
                list.add(y)
                return null
            }
            var curr: Int? = x
            while (curr != null) {
                curr = reduce(curr)
            }
            return list
        }

        // the first primes from 2 to 1 million
        // summoning costs you one white mana, one blue mana, and 500-600ms on my mbp
        val FIRST_PRIMES: List<Prime> by lazy {
            val list = ArrayList<Prime>(78498)
            for (i in 2..1000000) {
                of(i)?.let { list.add(it) }
            }
            Collections.unmodifiableList(list)
        }
    }
}