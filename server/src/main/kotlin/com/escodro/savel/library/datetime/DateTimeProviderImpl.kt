package com.escodro.savel.library.datetime

import kotlinx.datetime.Clock

internal class DateTimeProviderImpl : DateTimeProvider {
    override fun getCurrentTimeInMillis(): Long = Clock.System.now().toEpochMilliseconds()
}
