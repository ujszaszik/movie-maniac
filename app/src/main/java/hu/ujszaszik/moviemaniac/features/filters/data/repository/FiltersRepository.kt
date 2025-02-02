package hu.ujszaszik.moviemaniac.features.filters.data.repository

import hu.ujszaszik.moviemaniac.core.operation.cacheFlowOperation
import hu.ujszaszik.moviemaniac.core.operation.localDataOperation
import hu.ujszaszik.moviemaniac.features.filters.data.local.GenreDatabase
import hu.ujszaszik.moviemaniac.features.filters.data.model.Genre
import hu.ujszaszik.moviemaniac.features.filters.data.remote.FiltersService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FiltersRepository @Inject constructor(
    private val service: FiltersService,
    database: GenreDatabase
) : IFiltersRepository {

    private val dao = database.dao()

    override fun getFilters(): Flow<List<Genre>> =
        cacheFlowOperation(
            remoteCall = { service.getFilters() },
            saveLocal = { dao.insertGenres(it) },
            getLocal = { dao.getGenres() },
            mapper = { it.genres },
            onErrorReturn = { emptyList() },
            refreshCondition = { dao.getSize() == 0 }
        )

    override fun getSelection(): Flow<Genre?> =
        localDataOperation {
            dao.getSelected()
        }

    override suspend fun setSelection(id: Long) =
        withContext(Dispatchers.IO) {
            dao.setSelected(id)
        }
}