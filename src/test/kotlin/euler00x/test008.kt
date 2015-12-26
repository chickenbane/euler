package euler00x

import org.junit.Assert
import org.junit.Test

/**
 * Created by joeyt on 12/25/15.
 */
class Euler008Test {
    @Test fun checkParse() {
        Assert.assertEquals("1000 digit number", 1000, Euler008.bigNumList.size)
    }

    @Test fun checkChunkSize() {
        Assert.assertEquals("get first 13", 13, Euler008.chunk(0, 13).size)
        Assert.assertEquals("get last 13", 13, Euler008.chunk(1000 - 13, 13).size)
    }

    @Test(expected = IndexOutOfBoundsException::class) fun testBadChunkUnchecked() {
        Euler008.chunkUnchecked(1000-12, 13)
    }

    @Test(expected = IllegalArgumentException::class) fun testBadChunk() {
        Euler008.chunk(1000-12, 13)
    }

    @Test fun checkChunkContent() {
        // line 1:
        // 73167176531330624919225119674426574742355349194934
        Assert.assertEquals("chunk(0, 3) = [7, 3, 1]", listOf(7, 3, 1), Euler008.chunk(0, 3))
        Assert.assertEquals("chunk(3, 5) = [6, 7, 1, 7, 6]", listOf(6, 7, 1, 7, 6), Euler008.chunk(3, 5))
    }

    // The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
    @Test fun testDemo() {
        Assert.assertEquals("findMaxProductForLength(4) = 5832", 5832, Euler008.findMaxProductForLength(4))
    }

    @Test fun checkAnswer() {
        Assert.assertEquals("findMaxProductFoLength(13) = 23514624000", 23514624000, Euler008.findMaxProductForLength(13))
    }
}