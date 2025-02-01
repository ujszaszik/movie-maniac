package hu.ujszaszik.moviemaniac.features.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.moviemaniac.features.movies.domain.GetPagingMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    getPagingMovies: GetPagingMoviesUseCase
) : ViewModel() {

    val movies = getPagingMovies().cachedIn(viewModelScope)
}