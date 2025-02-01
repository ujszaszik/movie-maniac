package hu.ujszaszik.moviemaniac.core.operation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

inline fun <Local> localDataOperation(
    crossinline getLocal: suspend () -> Flow<Local>,
): Flow<Local> =
    flow {
        emitAll(getLocal())
    }.flowOn(Dispatchers.IO)