package euler03x

import java.util.*

/**
 * Created by joeyt on 2/8/16.
 */
object Euler031 {
    private val copyPasta = """
Coin sums
Problem 31
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
"""

    data class Change(val penny: Int,
                      val twop: Int,
                      val nickel: Int,
                      val dime: Int,
                      val twentyp: Int,
                      val half: Int,
                      val pound: Int,
                      val twoPound: Int) {
        val totalPence = penny + (2*twop) + (5*nickel) + (10*dime) + (20*twentyp) + (50*half) + (100*pound) + (200*twoPound)
        val isTwoPound = totalPence == 200
    }

    // the dumbest way i can think of doing it:
    fun answer(): Int {
        val set = HashSet<Change>()
        for (penny in 0..200) {
            for (twop in 0..100) {
                for (nickel in 0..40) {
                    for (dime in 0..20) {
                        for (twentyp in 0..10) {
                            for (half in 0..4) {
                                for (pound in 0..2) {
                                    for (twoPound in 0..1) {
                                        val change = Change(penny, twop, nickel, dime, twentyp, half, pound, twoPound)
                                        if (change.isTwoPound) {
                                            set.add(change)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return set.size
    }

}