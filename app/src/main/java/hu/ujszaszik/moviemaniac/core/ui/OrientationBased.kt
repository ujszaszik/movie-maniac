package hu.ujszaszik.moviemaniac.core.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun <T> orientationBased(landscape: T, portrait: T): T {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    return if (isLandscape) landscape else portrait
}