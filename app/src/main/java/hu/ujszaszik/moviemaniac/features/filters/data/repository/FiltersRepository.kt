package hu.ujszaszik.moviemaniac.features.filters.data.repository

import hu.ujszaszik.moviemaniac.core.network.cacheOperation
import hu.ujszaszik.moviemaniac.features.filters.data.local.GenreDatabase
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import hu.ujszaszik.moviemaniac.features.filters.data.remote.FiltersService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FiltersRepository @Inject constructor(
    private val service: FiltersService,
    database: GenreDatabase
) : IFiltersRepository {

    private val dao = database.dao()

    override suspend fun getFilters(): Flow<List<Genre>> =
        cacheOperation(
            remoteCall = { service.getFilters() },
            saveLocal = { dao.insertGenres(it) },
            getLocal = { dao.getGenres() },
            mapper = { it.genres },
            refreshCondition = { dao.getSize() == 0 }
        )
}