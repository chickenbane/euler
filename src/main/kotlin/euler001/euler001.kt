package euler001


// Multiples of 3 and 5
// Problem 1
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.


fun Int.isMultiple3or5(): Boolean {
    if (this <= 0) return false
    return (this % 3 == 0) || (this % 5 == 0)
}