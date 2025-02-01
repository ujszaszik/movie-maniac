package hu.ujszaszik.moviemaniac.features.filters.data.remote

import hu.ujszaszik.moviemaniac.core.network.WebService
import javax.inject.Inject

class FiltersService @Inject constructor(
    private val webService: WebService
) {
    suspend fun getFilters(): GenreResponse =
        webService.get("genre/movie/list")
}