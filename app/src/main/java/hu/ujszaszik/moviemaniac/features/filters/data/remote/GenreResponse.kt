package hu.ujszaszik.moviemaniac.features.filters.data.remote

import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import kotlinx.serialization.Serializable

@Serializable
data class GenreResponse(
    val genres: List<Genre>
)