package hu.ujszaszik.moviemaniac.features.movies.domain

import androidx.paging.PagingData
import androidx.paging.map
import hu.ujszaszik.moviemaniac.core.network.WebService
import hu.ujszaszik.moviemaniac.features.movies.data.repository.IMoviesRepository
import hu.ujszaszik.moviemaniac.features.movies.data.repository.MovieData
import hu.ujszaszik.moviemaniac.util.roundToOneDecimal
import hu.ujszaszik.moviemaniac.util.toMillionsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPagingMoviesUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    operator fun invoke(onInitialLoad: suspend (Boolean) -> Unit): Flow<PagingData<MovieUiModel>> =
        repository.getMoviesPaging(onInitialLoad)
            .map { pagingData ->
                pagingData.map {
                    it.toUiModel()
                }
            }

    private fun MovieData.toUiModel() =
        MovieUiModel(
            id = id,
            title = title,
            imageUrl = imagePath.asImageUrl(),
            rating = rating.roundToOneDecimal(),
            revenue = revenue.toMillionsText(),
            budget = budget.toMillionsText()
        )

    private fun String?.asImageUrl() = this?.let { "${WebService.IMAGE_URL}$it" }

}