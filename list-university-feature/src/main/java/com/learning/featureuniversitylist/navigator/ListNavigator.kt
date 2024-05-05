package com.learning.featureuniversitylist.navigator

import com.learning.dtos.ui.UniversityView

interface ListNavigator {
    fun goToDetail(universityView: UniversityView)
}