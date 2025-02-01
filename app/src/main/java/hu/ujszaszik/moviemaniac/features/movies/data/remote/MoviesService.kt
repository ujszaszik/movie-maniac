package hu.ujszaszik.moviemaniac.features.movies.data.remote

import hu.ujszaszik.moviemaniac.core.network.WebService
import io.ktor.client.request.parameter
import javax.inject.Inject

class MoviesService @Inject constructor(
    private val webService: WebService
) {

    suspend fun getMovies(page: Long): MovieResponse =
        webService.get("/discover/movie") {
            parameter("page", page)
            parameter("sort_by", "popularity.desc")
        }

    suspend fun getDetailsById(id: Long): MovieDetailResponse =
        webService.get("/movie/$id")
}