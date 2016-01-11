package euler01x


import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 1/10/16.
 */
class Euler014Test {

    // 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    // It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
    @Test
    fun checkDemo() {
        val seq = Euler014.collatzSeq(13)
        val expected = arrayListOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        Assert.assertEquals("seq starting at 13", expected, seq)
        Assert.assertEquals("10 terms", 10, seq.size)
    }

    // OH WHAT FUN! Be aware when using sequences of numbers
    // If using IntArray, use array specific assertFunction
    // Using ArrayList<Int>.equals does what you want.
    @Test
    fun checkIntArrayEquality() {
        val list1 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        val list2 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        Assert.assertArrayEquals("there's an assert just for arrays!", list1, list2)
    }

    @Test(expected = AssertionError::class)
    fun fyiIntArray() {
        val list1 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        val list2 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        Assert.assertEquals("these lists are equal...jk", list1, list2)
    }

    @Test
    fun checkArrayListEquality() {
        val list1 = arrayListOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        val list2 = arrayListOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        Assert.assertEquals("these lists are equal, seriously!", list1, list2)
        Assert.assertTrue("these lists are equal, seriously!", list1.equals(list2))
        Assert.assertTrue("these lists are equal, seriously!", list1 == list2)
    }

    @Test
    fun dontCompareIntArray() {
        val list1 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        val list2 = intArrayOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
        val list3 = arrayListOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)

        Assert.assertFalse(list1.equals(list2))
        Assert.assertFalse(list2.equals(list1))
        Assert.assertFalse(list3.equals(list1))
        Assert.assertFalse(list2.equals(list3))
        Assert.assertFalse(list1 == list2)
    }

    // i=106239 longest=354
    // seq=[106239, 318718, 159359, 478078, 239039, 717118, 358559, 1075678, 537839, 1613518,
    // 806759, 2420278, 1210139, 3630418, 1815209, 5445628, 2722814, 1361407, 4084222, 2042111,
    // 6126334, 3063167, 9189502, 4594751, 13784254, 6892127, 20676382, 10338191, 31014574,
    // 15507287, 46521862, 23260931, 69782794, 34891397, 104674192, 52337096, 26168548, 13084274,
    // 6542137, 19626412, 9813206, 4906603, 14719810, 7359905, 22079716, 11039858, 5519929,
    // 16559788, 8279894, 4139947, 12419842, 6209921, 18629764, 9314882, 4657441, 13972324,
    // 6986162, 3493081, 10479244, 5239622, 2619811, 7859434, 3929717, 11789152, 5894576, 2947288,
    // 1473644, 736822, 368411, 1105234, 552617, 1657852, 828926, 414463, 1243390, 621695, 1865086,
    // 932543, 2797630, 1398815, 4196446, 2098223, 6294670, 3147335, 9442006, 4721003, 14163010,
    // 7081505, 21244516, 10622258, 5311129, 15933388, 7966694, 3983347, 11950042, 5975021,
    // 17925064, 8962532, 4481266, 2240633, 6721900, 3360950, 1680475, 5041426, 2520713, 7562140,
    // 3781070, 1890535, 5671606, 2835803, 8507410, 4253705, 12761116, 6380558, 3190279, 9570838,
    // 4785419, 14356258, 7178129, 21534388, 10767194, 5383597, 16150792, 8075396, 4037698, 2018849,
    // 6056548, 3028274, 1514137, 4542412, 2271206, 1135603, 3406810, 1703405, 5110216, 2555108,
    // 1277554, 638777, 1916332, 958166, 479083, 1437250, 718625, 2155876, 1077938, 538969, 1616908,
    // 808454, 404227, 1212682, 606341, 1819024, 909512, 454756, 227378, 113689, 341068, 170534,
    // 85267, 255802, 127901, 383704, 191852, 95926, 47963, 143890, 71945, 215836, 107918, 53959,
    // 161878, 80939, 242818, 121409, 364228, 182114, 91057, 273172, 136586, 68293, 204880, 102440,
    // 51220, 25610, 12805, 38416, 19208, 9604, 4802, 2401, 7204, 3602, 1801, 5404, 2702, 1351,
    // 4054, 2027, 6082, 3041, 9124, 4562, 2281, 6844, 3422, 1711, 5134, 2567, 7702, 3851, 11554,
    // 5777, 17332, 8666, 4333, 13000, 6500, 3250, 1625, 4876, 2438, 1219, 3658, 1829, 5488, 2744,
    // 1372, 686, 343, 1030, 515, 1546, 773, 2320, 1160, 580, 290, 145, 436, 218, 109, 328, 164,
    // 82, 41, 124, 62, 31, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91,
    // 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186,
    // 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425,
    // 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644,
    // 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866,
    // 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160,
    // 80, 40, 20, 10, 5, 16, 8, 4, 2, 1]
    //
    // i=113382
    // java.lang.OutOfMemoryError: Java heap space
    //@Test
    fun bruteForceAnswer() {
        var longestSize = 0
        for (i in 1..1000000) {
            val seq = Euler014.collatzSeq(i)
            val seqSize = seq.size
            if (seqSize > longestSize) {
                longestSize = seqSize
                println("i=$i longest=$longestSize seq=$seq")
            }
        }
    }

    @Test
    fun checkApproach2() {
        Assert.assertEquals("10 terms", 10, Euler014.collatzSeqLen(13))
    }

    // This approach, which doesn't create a seq, hangs at i=113382
    // i=113383 is an infinite list?
    //@Test
    fun bruteForceAnswerNoList() {
        var longestSize = 0
        var indexOfLongest = 0
        for (i in 1..1000000) {
            val len = Euler014.collatzSeqLen(i)
            if (len > longestSize) {
                longestSize = len
                indexOfLongest = i
                println("i=$i longestSize=$longestSize")
            } else {println("else i=$i")}
        }
    }

    // AHH!  We overflowed an int.
    //    seqSize=117 next=1103160598
    //    seqSize=118 next=551580299
    //    seqSize=119 next=1654740898
    //    seqSize=120 next=827370449
    //    seqSize=121 next=-1812855948
    //@Test
    fun whatsGoingOn() {
        var c = 113383
        var seqSize = 1
        while (c != 1) {
            val next = Euler014.nextCollatz(c)
            seqSize += 1
            c = next

            println("seqSize=$seqSize next=$next")
            if (next < 0) {
                return
            }
        }
    }

    @Test
    fun answer() {
        var longestSize = 0
        var indexOfLongest = 0
        for (i in 1..1000000) {
            val len = Euler014.collatzSeqLen(i.toLong())
            if (len > longestSize) {
                longestSize = len
                indexOfLongest = i
                println("i=$i longestSize=$longestSize")
            }
        }
        Assert.assertEquals("correct answer!", 837799, indexOfLongest)
        Assert.assertEquals("longest length", 525, longestSize)
    }
}