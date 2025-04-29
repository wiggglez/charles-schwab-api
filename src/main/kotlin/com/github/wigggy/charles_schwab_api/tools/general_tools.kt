package com.github.wigggy.charles_schwab_api.tools

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.logging.Level
import java.util.logging.Logger

internal val Log: Logger = Logger.getGlobal()


internal fun Logger.w(tag: String, msg: String?) {
    Logger.getGlobal().warning(formatLogMsg(tag, msg))
}


internal fun Logger.d(tag: String, msg: String?) {
    Logger.getGlobal().log(Level.parse("DEBUG"), formatLogMsg(tag, msg))
}


internal fun Logger.i(tag: String, msg: String?) {
    Logger.getGlobal().log(Level.parse("INFO"), formatLogMsg(tag, msg))
}

private fun formatLogMsg(tag: String, msg: String?) : String {
    return "\t-- TAG: $tag --\n$msg"
}


fun convertTimestampToDateyyyyMMdd(timestamp: Long): String {
    // Convert the timestamp to a LocalDateTime
    val localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())

    // Define the formatter
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Format the LocalDateTime to a string
    return localDateTime.format(formatter)
}

