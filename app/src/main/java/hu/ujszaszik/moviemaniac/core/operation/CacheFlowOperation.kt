package hu.ujszaszik.moviemaniac.core.operation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

inline fun <Remote, Local> cacheFlowOperation(
    crossinline remoteCall: suspend () -> Remote,
    crossinline saveLocal: suspend (Local) -> Unit,
    crossinline getLocal: suspend () -> Flow<Local>,
    crossinline mapper: (Remote) -> Local,
    crossinline onErrorReturn: () -> Local,
    crossinline refreshCondition: () -> Boolean
): Flow<Local> =
    flow {
        try {
            if (refreshCondition()) {
                saveLocal(mapper(remoteCall()))
            }
            emitAll(getLocal())
        } catch (throwable: Throwable) {
            onErrorReturn()
        }
    }.flowOn(Dispatchers.IO)