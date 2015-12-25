package euler00x

//Sum square difference
//Problem 6
//The sum of the squares of the first ten natural numbers is,
//
//1^2 + 2^2 + ... + 10^2 = 385
//The square of the sum of the first ten natural numbers is,
//
//(1 + 2 + ... + 10)^2 = 55^2 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

fun sumOfSquares(top: Int): Int {
    return (1..top).toList().map { it * it }.sum()
}

fun squareOfSum(top: Int): Int {
    val sum = (1..top).toList().sum()
    return sum * sum
}

fun diffSumSquaresAndSquareSums(top: Int): Int = squareOfSum(top) - sumOfSquares(top)

fun main(args: Array<String>) {
    println("my answer = ${diffSumSquaresAndSquareSums(100)}")
}