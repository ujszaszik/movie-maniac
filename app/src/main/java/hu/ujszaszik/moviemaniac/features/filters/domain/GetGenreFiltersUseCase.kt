package hu.ujszaszik.moviemaniac.features.filters.domain

import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import hu.ujszaszik.moviemaniac.features.filters.data.repository.FiltersRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGenreFiltersUseCase @Inject constructor(
    private val repository: FiltersRepository
) {
    operator fun invoke() =
        repository.getFilters()
            .map { listOf(Genre.all()) + it }
}