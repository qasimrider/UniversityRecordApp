package com.learning.data.repository

import com.learning.common.base.Result
import com.learning.data.database.dao.UniDao
import com.learning.data.remote.network.UniversityWebService
import com.learning.data.utils.networkBoundResource
import com.learning.dtos.ui.UniversityView
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(
    private val universityWebService: UniversityWebService,
    private val uniDao: UniDao
) : UniversityRepository {
    override fun uaeUniversities(): Flow<Result<List<UniversityView>>> =
        networkBoundResource(
            query = { uniDao.getAllUniversities() },
            apiCall = { universityWebService.uaeUniversities() },
            saveFetchResults = { remote -> uniDao.insertAll(remote.map { it.toRoomEntity() }) },
            localToUiMapper = { it.map { it.toUi() } },
            remoteToUiMapper = { it.map { it.toUi() } }
        )
}