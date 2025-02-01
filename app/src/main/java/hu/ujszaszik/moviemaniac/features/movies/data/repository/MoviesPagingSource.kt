package hu.ujszaszik.moviemaniac.features.movies.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState

class MoviesPagingSource(
    private val loadSinglePage: suspend (Long) -> List<MovieData>,
    private val onInitialLoad: suspend (Boolean) -> Unit
) : PagingSource<Int, MovieData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        return try {
            val page = params.key ?: 1

            if (page == 1) onInitialLoad(true)
            val response = loadSinglePage(page.toLong())
            onInitialLoad(false)

            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            onInitialLoad(false)
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition?.let { state.closestPageToPosition(it)?.prevKey }
    }
}

