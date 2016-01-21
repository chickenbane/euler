package euler01x

import org.junit.Assert
import org.junit.Test
import java.util.*


/**
 * Created by joeyt on 1/21/16.
 */
class Euler019Test {

    @Test
    fun check1900() {
        val days = ArrayList<Euler019.DayOfYear>()
        var curr = Euler019.start
        while (curr.year == 1900) {
            days.add(curr)
            curr = curr.next()
        }
        Assert.assertEquals("365 days in a year", 365, days.size)
        val jan = days.filter { it.month == Month.JAN }
        Assert.assertEquals("31 days in jan", 31, jan.size)
    }

    @Test
    fun checkLeap() {
        val days = ArrayList<Euler019.DayOfYear>()
        var curr = Euler019.start
        while (curr.year <= 1904) {
            days.add(curr)
            curr = curr.next()
        }
        Assert.assertEquals("365 * 4 years + 366 ", 366+(365*4), days.size)
        val feb = days.filter { it.month == Month.FEB }
        Assert.assertEquals("28 days in 1900", 28, feb.filter { it.year == 1900 }.size)
        Assert.assertEquals("28 days in 1901", 28, feb.filter { it.year == 1901 }.size)
        Assert.assertEquals("28 days in 1902", 28, feb.filter { it.year == 1902 }.size)
        Assert.assertEquals("28 days in 1903", 28, feb.filter { it.year == 1903 }.size)
        Assert.assertEquals("29 days in 1904", 29, feb.filter { it.year == 1904 }.size)
    }

    // How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

    @Test
    fun answer() {
        val days = ArrayList<Euler019.DayOfYear>()
        var curr = Euler019.start
        while (curr.year < 2001) {
            days.add(curr)
            curr = curr.next()
        }
        val firstSundays = days.filter { it.year >= 1901 && it.monthDay == 1 && it.weekDay == Day.SUN }
        println("firstSundays = ${firstSundays.joinToString(separator = "\n")}")
        Assert.assertEquals("my answer", 171, firstSundays.size)
    }

}