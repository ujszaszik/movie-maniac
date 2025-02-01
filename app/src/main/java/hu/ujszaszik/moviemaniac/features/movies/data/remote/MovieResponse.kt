package hu.ujszaszik.moviemaniac.features.movies.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val page: Long,
    val results: List<MovieItemResponse>
)

@Serializable
data class MovieItemResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("backdrop_path")
    val imagePath: String,
    @SerialName("vote_average")
    val rating: Double
)

@Serializable
data class MovieDetailResponse(
    @SerialName("budget")
    val budget: Long,
    @SerialName("revenue")
    val revenue: Long
)