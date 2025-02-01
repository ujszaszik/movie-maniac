package hu.ujszaszik.moviemaniac.features.filters.data.repository

import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import kotlinx.coroutines.flow.Flow

interface IFiltersRepository {
    fun getFilters(): Flow<List<Genre>>
}