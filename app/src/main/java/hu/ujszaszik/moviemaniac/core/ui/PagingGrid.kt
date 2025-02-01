package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import hu.ujszaszik.moviemaniac.ui.theme.indicatorSize
import hu.ujszaszik.moviemaniac.ui.theme.paddingDouble

interface PagingItem {
    val id: Long
}

@Composable
fun <T : PagingItem> PagingGrid(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<T>,
    cellSize: Int,
    onError: (Throwable) -> Unit,
    itemContent: @Composable (T) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(cellSize),
        modifier = modifier
            .fillMaxSize()
            .padding(paddingDouble)
    ) {
        items(items.itemCount, key = { it }) { index ->
            val item = items[index]
            item?.let { itemContent.invoke(item) }
        }

        items.apply {
            when (val state = loadState.append) {
                is LoadState.Loading -> {
                    item { CircularProgressIndicator(modifier = Modifier.size(indicatorSize)) }
                }

                is LoadState.Error -> onError(state.error)

                else -> Unit
            }
        }
    }
}