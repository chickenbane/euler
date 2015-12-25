package euler00x

import org.junit.Assert
import org.junit.Test

class Euler006 {
    //The sum of the squares of the first ten natural numbers is,
    //
    //1^2 + 2^2 + ... + 10^2 = 385
    //The square of the sum of the first ten natural numbers is,
    //
    //(1 + 2 + ... + 10)^2 = 55^2 = 3025
    //Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
    @Test fun checkDemo() {
        Assert.assertEquals("3025-385=2640", 2640, diffSumSquaresAndSquareSums(10))
    }
}