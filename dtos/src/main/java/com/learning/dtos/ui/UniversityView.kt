package com.learning.dtos.ui

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class UniversityView(
    val id: Int,
    val name: String,
    val state: String?,
    val country: String,
    val webPage: String?,
    val countryCode: String
) : Parcelable {
    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<UniversityView> =
            object : DiffUtil.ItemCallback<UniversityView>() {
                override fun areItemsTheSame(
                    oldItem: UniversityView,
                    newItem: UniversityView
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: UniversityView,
                    newItem: UniversityView
                ): Boolean {
                    return true
                }
            }
    }
}