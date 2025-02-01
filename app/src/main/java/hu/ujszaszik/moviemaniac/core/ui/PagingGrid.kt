package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems

interface PagingItem {
    val id: Long
}

@Composable
fun <T : PagingItem> PagingGrid(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<T>,
    cellSize: Int,
    itemContent: @Composable (T) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(cellSize),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items.itemCount, key = { it }) { index ->
            val item = items[index]
            item?.let { itemContent.invoke(item) }
        }

        items.apply {
            when {
                loadState.append is androidx.paging.LoadState.Loading -> {
                    item { CircularProgressIndicator(modifier = Modifier.fillMaxWidth()) }
                }

                loadState.append is androidx.paging.LoadState.Error -> {
                    item {
                        Text("Error loading more data", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
    }
}