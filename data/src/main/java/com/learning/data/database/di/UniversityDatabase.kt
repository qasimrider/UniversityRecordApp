package com.learning.data.database.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learning.data.database.dao.UniDao
import com.learning.dtos.entity.UniversityEntity

@Database(entities = [UniversityEntity::class], version = 1, exportSchema = false)
abstract class UniversityDatabase: RoomDatabase() {
    abstract fun universityDao(): UniDao
}