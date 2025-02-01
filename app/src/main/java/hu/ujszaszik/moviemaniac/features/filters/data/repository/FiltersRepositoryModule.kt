package hu.ujszaszik.moviemaniac.features.filters.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FiltersRepositoryModule {

    @Binds
    fun bindFiltersRepository(filtersRepository: FiltersRepository): IFiltersRepository
}