package hu.ujszaszik.moviemaniac.core.operation

suspend inline fun <Remote, Local> simpleCacheOperation(
    crossinline remoteCall: suspend () -> Remote,
    crossinline saveLocal: suspend (Local) -> Unit,
    crossinline getLocal: suspend () -> Local?,
    crossinline mapper: (Remote) -> Local,
    crossinline refreshCondition: () -> Boolean
): Local? {
    if (refreshCondition()) {
        saveLocal(mapper(remoteCall()))
    }
    return getLocal()
}