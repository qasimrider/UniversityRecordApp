package com.learning.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learning.dtos.entity.UniversityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UniDao {
    @Query("SELECT * FROM UniversityEntity")
    fun getAllUniversities(): Flow<List<UniversityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<UniversityEntity>)
}