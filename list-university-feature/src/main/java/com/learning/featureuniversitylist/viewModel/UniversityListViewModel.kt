package com.learning.featureuniversitylist.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.learning.common.base.BaseViewModel
import com.learning.common.base.UiState
import com.learning.common.base.ViewState
import com.learning.data.repository.UniversityRepository
import com.learning.dtos.ui.UniversityView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityListViewModel @Inject constructor(private val universityRepository: UniversityRepository) :
    BaseViewModel<UniversityListUiState>() {

    private lateinit var universityListUiState: UniversityListUiState

    fun fetchUniversities() {
        viewModelScope.launch {
            universityRepository.uaeUniversities().collect { listUniversityView ->
                when (listUniversityView) {
                    is com.learning.common.base.Result.Success -> {
                        universityListUiState = UniversityListUiState(listUniversityView.data)
                        Log.d("University Data", "fetchUniversities: ${listUniversityView.data}")
                        _uiState.value =
                            UiState.Success(universityListUiState)
                    }

                    is com.learning.common.base.Result.Loading -> {
                        _uiState.value = UiState.Loading
                    }

                    is com.learning.common.base.Result.Error -> {
                        handleFailure(listUniversityView.exception)
                    }
                }
            }
        }

    }

}

data class UniversityListUiState(val universityList: List<UniversityView>) : ViewState