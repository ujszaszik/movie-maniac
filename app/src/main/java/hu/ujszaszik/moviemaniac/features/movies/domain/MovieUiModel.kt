package hu.ujszaszik.moviemaniac.features.movies.domain

import hu.ujszaszik.moviemaniac.core.ui.PagingItem

data class MovieUiModel(
    override val id: Long,
    val title: String,
    val imageUrl: String? = null,
    val rating: String,
    val revenue: String,
    val budget: String
) : PagingItem