package hu.ujszaszik.moviemaniac.features.movies.data.remote

import hu.ujszaszik.moviemaniac.core.network.WebService
import hu.ujszaszik.moviemaniac.core.network.retry
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import io.ktor.client.request.parameter
import javax.inject.Inject

class MoviesService @Inject constructor(
    private val webService: WebService
) {

    suspend fun getMovies(page: Long, genre: Genre?): MovieResponse =
        retry {
            webService.get("discover/movie") {
                parameter("page", page)
                parameter("sort_by", "popularity.desc")
                genre?.let { parameter("with_genres", genre.id) }
            }
        }

    suspend fun getDetailsById(id: Long): MovieDetailResponse =
        webService.get("movie/$id")
}