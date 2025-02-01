package hu.ujszaszik.moviemaniac.features.filters.data.repository

import hu.ujszaszik.moviemaniac.features.filters.data.remote.FiltersService
import hu.ujszaszik.moviemaniac.features.filters.data.remote.Genre
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FiltersRepository @Inject constructor(
    private val service: FiltersService
) : IFiltersRepository {

    override fun getFilters(): Flow<List<Genre>> =
        flow { emit(service.getFilters().genres) }
}