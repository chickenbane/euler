package euler01x

/**
 * Created by joeyt on 1/20/16.
 */
object Euler019 {
    private val copyPasta = """
Counting Sundays
Problem 19
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
"""
    private val initialThoughts = """
ugh, this is why people make libraries, who does this?!
"""

    private val numDaysMap = mapOf(
            Month.JAN to 31, Month.MAR to 31, Month.APR to 30, Month.MAY to 31, Month.JUN to 30,
            Month.JUL to 31, Month.AUG to 31, Month.SEP to 30, Month.OCT to 31, Month.NOV to 30, Month.DEC to 31
    )

    fun febDays(year: Int): Int = if (isLeap(year)) 29 else 28

    fun isLeap(year: Int): Boolean = ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0

    fun daysInMonth(mon: Month, year: Int): Int = if (mon == Month.FEB) febDays(year) else numDaysMap[mon]!!

    data class DayOfYear(val monthDay: Int, val month: Month, val year: Int, val weekDay: Day) {
        fun next(): DayOfYear {
            var nextMonthDay = monthDay + 1
            var nextMonth = month
            var nextYear = year

            val daysInMonth = daysInMonth(month, year)
            if (nextMonthDay > daysInMonth) {
                nextMonthDay = 1
                var nextMonthOrdinal = month.ordinal + 1
                if (nextMonthOrdinal >= Month.values().size) {
                    nextYear += 1
                    nextMonthOrdinal = 0
                }
                nextMonth = Month.values()[nextMonthOrdinal]
            }

            var nextWeekDayOrdinal = weekDay.ordinal + 1
            if (nextWeekDayOrdinal >= Day.values().size) nextWeekDayOrdinal = 0
            val nextWeekDay = Day.values()[nextWeekDayOrdinal]

            return DayOfYear(nextMonthDay, nextMonth, nextYear, nextWeekDay)
        }
    }

    val start = DayOfYear(1, Month.JAN, 1900, Day.MON)

}

enum class Day {
    MON, TUE, WED, THR, FRI, SAT, SUN
}

enum class Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}
