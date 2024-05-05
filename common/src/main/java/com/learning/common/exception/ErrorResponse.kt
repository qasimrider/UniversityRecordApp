package com.learning.common.exception

import java.io.IOException

class ErrorResponse(
    val Detail: String = "",
    val Status: Int? = null,
    val Title: String? = null,
    val Type: String? = null,
//    val errors: Errors // use this in future for detail messages
)

//class Errors(
//    val error: List<String>
//)

class NetworkApiException(val error: ErrorResponse) : IOException()
