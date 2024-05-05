package com.learning.common.exception

import android.database.sqlite.SQLiteException

sealed class UniversityErrors {

    class BadRequest(val apiError: ErrorResponse?) : UniversityErrors()

    class ServerErrors(val error: Throwable) : UniversityErrors()
    class RoomErrors(val exception: SQLiteException? = null) : UniversityErrors()

    class NetworkErrors(val errorResponse: ErrorResponse) : UniversityErrors()

    object AuthorizationErrors : UniversityErrors()
    object UnknownServerErrors : UniversityErrors()
    object NetworkConnection : UniversityErrors()
    object AuthErrors : UniversityErrors()
    object Forbidden : UniversityErrors()
    object NotFound : UniversityErrors()
    object UnSupportedMediaType : UniversityErrors()
    object MalFormedJson : UniversityErrors()
    object IllegalStateException : UniversityErrors()
    object JsonSyntaxException : UniversityErrors()
    object SocketTimedOutException : UniversityErrors()
    object InternalServerErrors : UniversityErrors()
    object AndroidErrors : UniversityErrors()
    object FacebookLoginErrors : UniversityErrors()
    object NoErrors : UniversityErrors()

}
