package com.learning.common.base

import androidx.lifecycle.ViewModel
import com.learning.common.exception.ErrorResponse
import com.learning.common.exception.UniversityErrors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<UIState : ViewState> : ViewModel() {

    protected val _uiState = MutableStateFlow<UiState<UIState>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun setUiStateToInitialization() {
        _uiState.value = UiState.Initialization
    }

    protected fun handleFailure(errors: UniversityErrors) {

        _uiState.value = when (errors) {
            //Handle all the errors and its messages
//            UniversityErrors.AndroidErrors -> TODO()
//            UniversityErrors.AuthErrors -> TODO()
//            UniversityErrors.AuthorizationErrors -> TODO()
//            is UniversityErrors.BadRequest -> TODO()
//            UniversityErrors.FacebookLoginErrors -> TODO()
//            UniversityErrors.Forbidden -> TODO()
//            UniversityErrors.IllegalStateException -> TODO()
//            UniversityErrors.InternalServerErrors -> TODO()
//            UniversityErrors.JsonSyntaxException -> TODO()
//            UniversityErrors.MalFormedJson -> TODO()
//            UniversityErrors.NetworkConnection -> TODO()
            is UniversityErrors.NetworkErrors -> UiState.Error(errors.errorResponse)
//            UniversityErrors.NoErrors -> TODO()
//            UniversityErrors.NotFound -> TODO()
//            is UniversityErrors.RoomErrors -> TODO()
//            is UniversityErrors.ServerErrors -> TODO()
//            UniversityErrors.SocketTimedOutException -> TODO()
//            UniversityErrors.UnSupportedMediaType -> TODO()
//            UniversityErrors.UnknownServerErrors -> TODO()
            else -> {
                UiState.Error(ErrorResponse(Detail = "Something went wrong"))
            }
        }
    }

}

interface ViewState
sealed class UiState<out T> {
    data class Success<out R>(val data: R) : UiState<R>()
    data class Error(val errorResponse: ErrorResponse) : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    object Initialization : UiState<Nothing>()
}