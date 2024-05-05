package com.learning.dtos.api

import com.learning.dtos.entity.UniversityEntity
import com.learning.dtos.ui.UniversityView
import com.squareup.moshi.Json

class UniversityApi(
    @Json(name = "alpha_two_code") val alphaTwoCode: String,
    val name: String,
    val country: String,
    val domains: List<String>,
    @Json(name = "web_pages") val webPages: List<String>,
    @Json(name = "state-province") val stateProvince: String?
) {
    fun toUi() = UniversityView(
        id = System.currentTimeMillis().toInt(),
        name = this.name,
        state = this.stateProvince,
        country = this.country,
        webPage = this.webPages.firstOrNull(),
        countryCode = this.alphaTwoCode
    )

    fun toRoomEntity() = UniversityEntity(
        name = this.name,
        state = this.stateProvince,
        country = this.country,
        countryCode = this.alphaTwoCode,
        webPage = this.webPages.firstOrNull()
    )
}