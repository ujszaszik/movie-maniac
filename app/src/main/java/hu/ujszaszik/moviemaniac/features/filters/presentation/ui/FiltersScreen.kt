package hu.ujszaszik.moviemaniac.features.filters.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import hu.ujszaszik.moviemaniac.features.filters.presentation.viewmodel.FiltersViewModel

@Composable
fun FiltersScreen(viewModel: FiltersViewModel = hiltViewModel()) {
    val filters = viewModel.genres.collectAsState(emptyList())

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        items(filters.value) { filter ->
            FilterItemScreen(filter) { }
        }
    }
}