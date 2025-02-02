package hu.ujszaszik.moviemaniac.features.movies.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import hu.ujszaszik.moviemaniac.core.ui.EditIcon
import hu.ujszaszik.moviemaniac.core.ui.EmptyContent
import hu.ujszaszik.moviemaniac.core.ui.LoadingContent
import hu.ujszaszik.moviemaniac.core.ui.PagingGrid
import hu.ujszaszik.moviemaniac.core.ui.orientationBased
import hu.ujszaszik.moviemaniac.features.movies.presentation.viewmodel.MoviesViewModel

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    onEdit: () -> Unit
) {
    val pagingMovies = viewModel.movies.collectAsLazyPagingItems()
    val isInitialLoad = viewModel.isInitialLoad.collectAsState(true)
    var error by remember { mutableStateOf<Throwable?>(null) }
    val isEmpty = remember {
        derivedStateOf {
            pagingMovies.itemCount == 0 && !isInitialLoad.value
        }
    }

    Scaffold(floatingActionButton = { EditIcon { onEdit() } }) { innerPadding ->
        LoadingContent(isInitialLoad.value) {
            PagingGrid(
                modifier = Modifier.padding(innerPadding),
                items = pagingMovies,
                cellSize = orientationBased(portrait = 3, landscape = 5),
                onError = { error = it }
            ) { MovieItemScreen(it) }
        }
        EmptyContent(
            visible = isEmpty.value,
            error = error,
            onButtonClick = {
                error = null
                viewModel.invalidate()
            }
        )
    }
}