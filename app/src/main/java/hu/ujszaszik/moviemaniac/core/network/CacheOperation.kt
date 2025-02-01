package hu.ujszaszik.moviemaniac.core.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

inline fun <Remote, Local> cacheOperation(
    crossinline remoteCall: suspend () -> Remote,
    crossinline saveLocal: suspend (Local) -> Unit,
    crossinline getLocal: suspend () -> Local,
    crossinline mapper: (Remote) -> Local,
    crossinline refreshCondition: () -> Boolean
): Flow<Local> =
    flow {
        withContext(Dispatchers.IO) {
            if (refreshCondition()) {
                saveLocal(mapper(remoteCall()))
            }
            emit(getLocal())
        }
    }