package hu.ujszaszik.moviemaniac.features.movies.data.repository

data class MovieData(
    val id: Long,
    val title: String,
    val posterPath: String,
    val rating: Double,
    val budget: Long,
    val revenue: Long
)