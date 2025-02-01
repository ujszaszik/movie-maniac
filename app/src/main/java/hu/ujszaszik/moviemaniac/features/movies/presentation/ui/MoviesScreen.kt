package hu.ujszaszik.moviemaniac.features.movies.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import hu.ujszaszik.moviemaniac.core.ui.EditIcon
import hu.ujszaszik.moviemaniac.core.ui.PagingGrid
import hu.ujszaszik.moviemaniac.core.ui.orientationBased
import hu.ujszaszik.moviemaniac.features.movies.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    onEdit: () -> Unit
) {
    val pagingMovies = viewModel.movies.collectAsLazyPagingItems()

    Scaffold(
        floatingActionButton = {
            EditIcon { onEdit() }
        }
    ) { innerPadding ->
        PagingGrid(
            modifier = Modifier.padding(innerPadding),
            items = pagingMovies,
            cellSize = orientationBased(portrait = 3, landscape = 5)
        ) { MovieItemScreen(it) }
    }
}