package euler00x

import java.util.*

//Smallest multiple
//Problem 5
//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

fun smallestMultipleDown(n: Int): Int {
    var multiple = n
    for (i in n downTo 2) {
        if (multiple % i != 0) {
            println("multiplying by $i")
            multiple *= i
        }
    }
    return multiple
}

// hmm, going downwards won't give you the smallest


fun smallestMultipleUp(n: Int): Int {
    var multiple = 2
    for (i in 3..n) {
        if (multiple % i != 0) {
            println("multiplying by $i")
            multiple *= i
        }
    }
    return multiple
}

// okay, this simple method doesn't work.  reuse findFactors from 003 !

// ... dumb implemtation problems:
// 1) the product of adding all factors to one list is too big, but
// 2) the product of only adding distinct primes is too small.

/* RETHINK
smallestMultiple(1) = 1
2 = 2
3 = 6 (3,2)
4 = 12 (3,2,2)    * (2,2) need to merge
5 = 60 (5,3,2,2)
6 = 60            * (3,2) already included
7 = 420 (7,5,3,2,2)
8 = 840 (7,5,3,2,2,2) * (2,2,2) need to merge
9 = 2520 (7,5,3,3,2,2,2) * (3,3) need to merge
10 = 2520 * already included
 */

// I don't know why 003 used Longs for all that factoring stuff.  Quick rewrite!

fun reduce(n: Int): Pair<Int, Int> {
    for (i in 2..n) {
        if (n % i == 0) {
            return i to n/i
        }
    }
    return 1 to n
}

fun Pair<Int, Int>.isPrimeFactor(): Boolean = first == 1 || second == 1

fun factorize(n: Int): List<Int> {
    val primeFactors = ArrayList<Int>()
    val toFactor = ArrayList<Int>()
    toFactor.add(n)
    while (toFactor.isNotEmpty()) {
        val x = toFactor.removeAt(0)
        val pair = reduce(x)
        if (pair.isPrimeFactor()) {
            primeFactors.addAll(pair.toList())
        } else {
            toFactor.addAll(pair.toList())
        }
    }

    return primeFactors.filter { it != 1 }
}

fun smallestMultiple(n: Int): Int {
    val primes = ArrayList<Int>()
    for (i in 2..n) {
        val factors = factorize(i)
        val disjoint = factors.removePresent(primes)
        primes.addAll(disjoint)
    }
    println("primes are $primes")
    return primes.fold(1) { acc, n -> acc * n }
}

// containsAll just iterates over all elements and runs .contains().
// Problem is a factor like 4 or 8, which contain multiples of one element.
// kotlin helpers like .intersect() aren't helpful because they convert to Sets, which don't allow dupes
// list1.removePresent(list2) will return list1 elements that do not exist in list2, but also counts duplicates
fun List<Int>.removePresent(primes: ArrayList<Int>): List<Int> {
    val check = primes.toArrayList()  // copy primes, we don't want to change list passed in
    return this.filter { check.notFound(it) }
}

// returns true if the element is not in this list, meant to be used in filter()
// if return false, also drops the element so we can track duplicates
fun ArrayList<Int>.notFound(x: Int): Boolean {
    val i = indexOf(x)
    if (i == -1) return true
    removeAt(i)
    return false
}



fun main(args: Array<String>) {
    println("smallestMultiple∂(20)=${smallestMultiple(20)}")
}