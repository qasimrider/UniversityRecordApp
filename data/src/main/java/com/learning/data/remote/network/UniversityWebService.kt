package com.learning.data.remote.network

import com.learning.dtos.api.UniversityApi
import retrofit2.http.GET

interface UniversityWebService {
    @GET(value = "search?country=United%20Arab%20Emirates")
    suspend fun uaeUniversities(): List<UniversityApi>
}