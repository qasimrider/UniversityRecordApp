package com.learning.data.database.di

import android.content.Context
import androidx.room.Room
import com.learning.data.database.dao.UniDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideUniversityDatabase(@ApplicationContext context: Context): UniversityDatabase =
        Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            "universityDB"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideUniversityDao(database: UniversityDatabase): UniDao =
        database.universityDao()

}