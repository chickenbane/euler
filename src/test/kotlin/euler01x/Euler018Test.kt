package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/20/16.
 */
class Euler018Test {
    val example = """
3
7 4
2 4 6
8 5 9 3
    """

    val problem = """
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    """

    // reused in problem 67
    companion object {
        // checks if each row has one more element than the previous
        fun isTriangleArray(arr: Array<IntArray>): Boolean {
            for ((i, intarr) in arr.withIndex()) {
                if (intarr.size != (i + 1)) {
                    return false
                }
            }
            return true
        }
    }

    @Test
    fun checkParsing() {

        val exampleArray = Euler018.stringTo2dArray(example)
        Assert.assertEquals("example has four rows", 4, exampleArray.size)
        Assert.assertTrue("example is triangle array", isTriangleArray(exampleArray))

        val problemArray = Euler018.stringTo2dArray(problem)
        Assert.assertEquals("problem has 15 rows", 15, problemArray.size)
        Assert.assertTrue("problem array is triangle array", isTriangleArray(problemArray))
    }

    @Test
    fun checkDemo() {
        val exampleArray = Euler018.stringTo2dArray(example)
        Assert.assertEquals("example max is 23", 23, Euler018.findMaxSum(exampleArray))
        val expectedLongs = longArrayOf(20, 19, 23, 16)
        println("My last example row=" + Euler018.calcLastRow(exampleArray).joinToString())
        Assert.assertArrayEquals("calculated last row of example", expectedLongs, Euler018.calcLastRow(exampleArray))
    }

    @Test
    fun answer() {
        val problemArray = Euler018.stringTo2dArray(problem)
        println("My last row = " + Euler018.calcLastRow(problemArray).joinToString())
        Assert.assertEquals("my answer", 1074, Euler018.findMaxSum(problemArray))
    }

}