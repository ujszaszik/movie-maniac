package hu.ujszaszik.moviemaniac.features.filters.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreResponse(
    val genres: List<Genre>
)

@Serializable
data class Genre(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String
)