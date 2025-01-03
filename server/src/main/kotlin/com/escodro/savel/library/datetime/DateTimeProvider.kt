package com.escodro.savel.library.datetime

internal interface DateTimeProvider {
    fun getCurrentTimeInMillis(): Long
}
