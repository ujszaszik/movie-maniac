package hu.ujszaszik.moviemaniac.features.filters.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.moviemaniac.features.filters.domain.GetGenreFiltersUseCase
import hu.ujszaszik.moviemaniac.features.filters.domain.SetGenreFilterSelectionUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    getGenreFilters: GetGenreFiltersUseCase,
    private val setGenreFilterSelection: SetGenreFilterSelectionUseCase
) : ViewModel() {

    val genres = getGenreFilters()

    internal fun setSelected(genreId: Long) {
        viewModelScope.launch {
            setGenreFilterSelection(genreId)
        }
    }
}