package com.msoe.bnrtextapps.criminalintent

import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class DateUtils {
    companion object {
        fun getLocalizedDateString(d: Date): String {
            var df: DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(df)
        }
    }
}