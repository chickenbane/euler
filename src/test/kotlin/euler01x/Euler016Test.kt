package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/15/16.
 */
class Euler016Test {

    // 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

    @Test
    fun checkDemo() {

        Assert.assertEquals("hey remember this isn't 26", 266, Euler016.sumOfDigits(2,15))
        Assert.assertEquals("v2 2^15=32768 sum of 3 + 2 + 7 + 6 + 8", 26, Euler016.sumOfDigitsV2(2,15))


        Assert.assertEquals("answer", 1366, Euler016.sumOfDigitsV2(2,1000))

    }

    @Test
    fun warnStringToListOfInts() {
        val powString = Euler016.powString(2, 15)
        println("powString(2, 15)=$powString")
        val arraylist = powString.toArrayList()
        println("powString.toArrayList=" + arraylist)
        val listToInt = arraylist.map { it.toInt() }
        val listToStringToInt = arraylist.map { it.toString().toInt() }
        println("listToInt=$listToInt")
        println("listToStringToInt=$listToStringToInt")

        // powString(2, 15)=32768
        // powString.toArrayList=[3, 2, 7, 6, 8]
        // listToInt=[51, 50, 55, 54, 56]
        // listToStringToInt=[3, 2, 7, 6, 8]
        Assert.assertEquals("stringArray to list<char> to int", listOf(51, 50, 55, 54, 56), listToInt)
        Assert.assertEquals("stringArray to list<char> to string to int", listOf(3, 2, 7, 6, 8), listToStringToInt)
    }

}