package hu.ujszaszik.moviemaniac.features.movies.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {
    fun getMoviesPaging(): Flow<PagingData<MovieData>>
}