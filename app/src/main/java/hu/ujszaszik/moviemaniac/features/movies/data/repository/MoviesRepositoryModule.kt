package hu.ujszaszik.moviemaniac.features.movies.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MoviesRepositoryModule {

    @Binds
    fun bindMoviesRepository(moviesRepository: MoviesRepository): IMoviesRepository
}