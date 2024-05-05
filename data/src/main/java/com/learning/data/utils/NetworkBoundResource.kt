package com.learning.data.utils

import com.learning.common.base.Result
import com.learning.common.exception.toError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn


inline fun <DbType, RemoteType, ReturnType> networkBoundResource(
    crossinline query: () -> Flow<DbType> = { flowOf() },
    crossinline apiCall: suspend () -> RemoteType,
    crossinline localToUiMapper: (DbType) -> ReturnType,
    crossinline remoteToUiMapper: (RemoteType) -> ReturnType,
    noinline saveFetchResults: suspend (RemoteType) -> Unit,
) =
    flow {
        try {
            //fetch local data from room
            //Room either returns an empty list , or a null object , depending on the return type of the query
            val localData = query().firstOrNull()

            val localUiData = localData?.let {
                //convert local to UI
                val localUiData = localToUiMapper(it)
                //if type is of Collection , only emit if not empty
                emitLocal(localUiData)
                localUiData
            }

            val remoteData = apiCall()
            //convert remote to UI
            val remoteUiData = remoteToUiMapper(remoteData)

            //emit again , if there was a change in the datasets
            if (localUiData != null && (localUiData != remoteUiData)) {
                saveFetchResults(remoteData)
                emit(Result.Success(localToUiMapper(query().first())))
            } else { //If local didn't emit , we would still want to emit remote
                emit(Result.Success(remoteUiData))
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            emit(Result.Error(ex.toError()))
        }
    }.flowOn(Dispatchers.IO)

suspend fun <ReturnType> FlowCollector<Result<ReturnType>>.emitLocal(localUiData: ReturnType) {
    if (localUiData is Collection<*>) {
        if (localUiData.isNotEmpty()) {
            //emit whatever was found straight up
            emit(Result.Success(localUiData))
        }
    } else {
        //emit whatever was found straight up
        emit(Result.Success(localUiData))
    }
}