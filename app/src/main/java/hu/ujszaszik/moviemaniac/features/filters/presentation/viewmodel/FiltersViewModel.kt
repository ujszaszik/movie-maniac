package hu.ujszaszik.moviemaniac.features.filters.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.moviemaniac.features.filters.domain.GetGenreFiltersUseCase
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    getGenreFilters: GetGenreFiltersUseCase
) : ViewModel() {

    val genres = getGenreFilters()
}