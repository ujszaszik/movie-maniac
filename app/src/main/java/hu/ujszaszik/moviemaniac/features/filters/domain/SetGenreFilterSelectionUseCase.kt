package hu.ujszaszik.moviemaniac.features.filters.domain

import hu.ujszaszik.moviemaniac.features.filters.data.repository.FiltersRepository
import javax.inject.Inject

class SetGenreFilterSelectionUseCase @Inject constructor(
    private val repository: FiltersRepository
) {
    suspend operator fun invoke(genreId: Long) =
        repository.setSelection(genreId)
}