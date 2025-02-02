package hu.ujszaszik.moviemaniac.features.filters.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import hu.ujszaszik.moviemaniac.core.ui.EmptyContent
import hu.ujszaszik.moviemaniac.features.filters.presentation.viewmodel.FiltersViewModel
import hu.ujszaszik.moviemaniac.ui.theme.emptyButtonGoBack

@Composable
fun FiltersScreen(
    modifier: Modifier = Modifier,
    viewModel: FiltersViewModel = hiltViewModel(),
    onFinished: () -> Unit
) {
    val filters = viewModel.genres.collectAsState(emptyList())
    val isEmpty = remember {
        derivedStateOf {
            filters.value.isEmpty()
        }
    }

    LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        items(filters.value) { filter ->
            FilterItemScreen(filter) {
                viewModel.setSelected(filter.id)
                onFinished()
            }
        }
    }

    EmptyContent(
        visible = isEmpty.value,
        buttonText = emptyButtonGoBack,
        onButtonClick = { onFinished() }
    )

    BackHandler {
        onFinished()
    }
}