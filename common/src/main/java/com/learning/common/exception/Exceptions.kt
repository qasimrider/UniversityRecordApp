package com.learning.common.exception

import android.util.MalformedJsonException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun Throwable.toError(): UniversityErrors {
    return when (this) {
        is SecurityException -> UniversityErrors.AndroidErrors
        is UnknownHostException -> UniversityErrors.NetworkConnection
        is MalformedJsonException -> UniversityErrors.MalFormedJson
        is IllegalStateException -> UniversityErrors.IllegalStateException
        is SocketTimeoutException -> UniversityErrors.SocketTimedOutException
        is NetworkApiException -> UniversityErrors.NetworkErrors(this.error)
        else -> UniversityErrors.ServerErrors(this)
    }
}

fun handleUniversityErrors(errors: UniversityErrors) {
    when (errors) {
        UniversityErrors.AndroidErrors -> TODO()
        UniversityErrors.AuthErrors -> TODO()
        UniversityErrors.AuthorizationErrors -> TODO()
        is UniversityErrors.BadRequest -> TODO()
        UniversityErrors.FacebookLoginErrors -> TODO()
        UniversityErrors.Forbidden -> TODO()
        UniversityErrors.IllegalStateException -> TODO()
        UniversityErrors.InternalServerErrors -> TODO()
        UniversityErrors.JsonSyntaxException -> TODO()
        UniversityErrors.MalFormedJson -> TODO()
        UniversityErrors.NetworkConnection -> TODO()
        is UniversityErrors.NetworkErrors -> TODO()
        UniversityErrors.NoErrors -> TODO()
        UniversityErrors.NotFound -> TODO()
        is UniversityErrors.RoomErrors -> TODO()
        is UniversityErrors.ServerErrors -> TODO()
        UniversityErrors.SocketTimedOutException -> TODO()
        UniversityErrors.UnSupportedMediaType -> TODO()
        UniversityErrors.UnknownServerErrors -> TODO()
    }
}
