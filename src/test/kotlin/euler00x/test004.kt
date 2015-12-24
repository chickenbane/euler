package euler00x

import org.junit.Assert
import org.junit.Test

class Euler004 {
    @Test fun palindrome() {
        Assert.assertFalse("123 ", 123.isPalindrome())
        Assert.assertTrue("22", 22.isPalindrome())
        Assert.assertFalse("23", 23.isPalindrome())
        Assert.assertTrue("212", 212.isPalindrome())
        Assert.assertTrue("12321", 12321.isPalindrome())
        Assert.assertFalse("4545", 4545.isPalindrome())
        Assert.assertTrue("4554", 4554.isPalindrome())
    }
}