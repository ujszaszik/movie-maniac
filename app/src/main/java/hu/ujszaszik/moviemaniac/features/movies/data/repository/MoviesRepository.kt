package hu.ujszaszik.moviemaniac.features.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import hu.ujszaszik.moviemaniac.features.filters.data.repository.IFiltersRepository
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MovieDetailResponse
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MovieItemResponse
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesService: MoviesService,
    private val filtersRepository: IFiltersRepository
) : IMoviesRepository {

    val pager = { genre: Genre?, onInitialLoad: suspend (Boolean) -> Unit ->
        Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                MoviesPagingSource(
                    onInitialLoad = { onInitialLoad(it) },
                    loadSinglePage = { getMovies(it, genre) }
                )
            }
        )
    }

    override fun getMoviesPaging(onInitialLoad: suspend (Boolean) -> Unit): Flow<PagingData<MovieData>> =
        filtersRepository.getSelection()
            .distinctUntilChanged()
            .flatMapLatest { genre -> pager(genre, onInitialLoad).flow }

    private suspend fun getMovies(page: Long, genre: Genre?): List<MovieData> =
        withContext(Dispatchers.IO) {
            val movies = moviesService.getMovies(page, genre)
            val details = getMovieDetails(movies.results)
            return@withContext movies.results.map {
                val detail = details[it.id]
                MovieData(
                    id = it.id,
                    title = it.title,
                    rating = it.rating,
                    imagePath = it.imagePath,
                    revenue = detail?.revenue ?: 0L,
                    budget = detail?.budget ?: 0L
                )
            }
        }

    private suspend fun getMovieDetails(items: List<MovieItemResponse>): Map<Long, MovieDetailResponse> {
        return withContext(Dispatchers.IO) {
            items.associate { item ->
                item.id to async { moviesService.getDetailsById(item.id) }.await()
            }
        }
    }
}