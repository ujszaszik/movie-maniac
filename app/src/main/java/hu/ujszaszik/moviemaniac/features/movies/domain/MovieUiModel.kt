package hu.ujszaszik.moviemaniac.features.movies.domain

data class MovieUiModel(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val rating: String,
    val revenue: String,
    val budget: String
)