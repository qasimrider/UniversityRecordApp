package com.learning.data.remote.di

import com.learning.data.repository.UniversityRepository
import com.learning.data.repository.UniversityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsUniversityRepository(universityRepositoryRepository: UniversityRepositoryImpl): UniversityRepository
}


