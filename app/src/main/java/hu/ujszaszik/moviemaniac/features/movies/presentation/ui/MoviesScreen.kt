package hu.ujszaszik.moviemaniac.features.movies.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import hu.ujszaszik.moviemaniac.core.ui.PagingGrid
import hu.ujszaszik.moviemaniac.core.ui.orientationBased
import hu.ujszaszik.moviemaniac.features.movies.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val pagingMovies = viewModel.movies.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        PagingGrid(
            items = pagingMovies,
            cellSize = orientationBased(portrait = 3, landscape = 5)
        ) {
            Text(it.title)
        }
    }
}