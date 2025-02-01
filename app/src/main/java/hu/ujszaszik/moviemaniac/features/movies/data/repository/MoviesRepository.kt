package hu.ujszaszik.moviemaniac.features.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MovieDetailResponse
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MovieItemResponse
import hu.ujszaszik.moviemaniac.features.movies.data.remote.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesService: MoviesService
) : IMoviesRepository {

    override fun getMoviesPaging(): Flow<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { MoviesPagingSource { getMovies(it) } }
        ).flow
    }

    private suspend fun getMovies(page: Long): List<MovieData> =
        withContext(Dispatchers.IO) {
            val movies = moviesService.getMovies(page)
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