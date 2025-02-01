package hu.ujszaszik.moviemaniac.features.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.moviemaniac.features.movies.domain.GetPagingMoviesUseCase
import hu.ujszaszik.moviemaniac.features.movies.domain.ReloadMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    getPagingMovies: GetPagingMoviesUseCase,
    private val reloadMovies: ReloadMoviesUseCase
) : ViewModel() {
    private val _isInitialLoad = MutableStateFlow(false)
    internal val isInitialLoad: StateFlow<Boolean> = _isInitialLoad

    val movies = getPagingMovies { _isInitialLoad.emit(it) }
        .cachedIn(viewModelScope)

    fun invalidate() = reloadMovies()
}