package com.learning.data.repository

import com.learning.common.base.Result
import com.learning.dtos.ui.UniversityView
import kotlinx.coroutines.flow.Flow

interface UniversityRepository {
    fun uaeUniversities(): Flow<Result<List<UniversityView>>>
}