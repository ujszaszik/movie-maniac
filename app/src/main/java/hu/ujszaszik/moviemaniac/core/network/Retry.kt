package hu.ujszaszik.moviemaniac.core.network

import kotlinx.coroutines.delay
import java.util.concurrent.CancellationException

suspend fun <T> retry(
    maxRetries: Int = 3,
    delayMillis: Long = 1000L,
    block: suspend () -> T
): T {
    var lastException: Exception? = null
    var attempt = 0

    while (attempt < maxRetries) {
        try {
            return block()
        } catch (e: Exception) {
            lastException = e
            attempt++
            if (attempt < maxRetries) {
                delay(delayMillis)
            }
        }
    }
    throw lastException ?: CancellationException("Could not fetch remote data.")
}
