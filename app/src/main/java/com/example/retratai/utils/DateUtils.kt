package com.example.retratai.utils

import java.text.DateFormat
import java.util.*

class DateUtils {
     fun getDate(): String {
        val dateFormat = DateFormat.getDateInstance()
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }
}