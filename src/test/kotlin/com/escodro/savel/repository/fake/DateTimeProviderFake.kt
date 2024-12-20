package com.escodro.savel.repository.fake

import com.escodro.savel.library.datetime.DateTimeProvider

internal class DateTimeProviderFake : DateTimeProvider {
    var currentTime: Long = 0

    override fun getCurrentTimeInMillis(): Long = currentTime

    fun clear() {
        currentTime = 0
    }
}
