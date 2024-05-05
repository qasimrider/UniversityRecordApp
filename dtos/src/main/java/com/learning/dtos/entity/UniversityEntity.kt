package com.learning.dtos.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.learning.dtos.ui.UniversityView

@Entity
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val country: String,
    val countryCode: String,
    val state: String?,
    val webPage: String?
) {
    fun toUi() = UniversityView(
        id = this.id,
        name = this.name,
        state = this.state,
        country = this.country,
        webPage = this.webPage,
        countryCode = this.countryCode
    )
}