package hu.ujszaszik.moviemaniac.features.movies.domain

import hu.ujszaszik.moviemaniac.features.movies.data.repository.IMoviesRepository
import javax.inject.Inject

class ReloadMoviesUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    operator fun invoke() = repository.reloadMovies()
}