package hu.ujszaszik.moviemaniac.features.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import hu.ujszaszik.moviemaniac.core.ui.SlidingContent
import hu.ujszaszik.moviemaniac.features.filters.presentation.ui.FiltersScreen
import hu.ujszaszik.moviemaniac.features.movies.presentation.ui.MoviesScreen

@Composable
fun AppScreen() {
    var isMainPage by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        SlidingContent(isMainPage) { targetPage ->
            if (targetPage) {
                MoviesScreen(
                    onEdit = { isMainPage = false }
                )
            } else {
                FiltersScreen(
                    onFinished = { isMainPage = true }
                )
            }
        }
    }
}