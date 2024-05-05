package navigator

import android.os.Bundle
import androidx.navigation.NavController
import com.learning.dtos.ui.UniversityView
import com.learning.feature_university_detail.navigator.DetailNavigator
import com.learning.featureuniversitylist.navigator.ListNavigator
import com.learning.universityrecordapp.R
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : DetailNavigator, ListNavigator {

    private lateinit var navController: NavController

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun backToList() {
        navController.popBackStack()
    }

    override fun goToDetail(universityView: UniversityView) {
        val bundle = Bundle().apply {
            putParcelable("uni-detail", universityView)
        }
        navController.navigate(R.id.toDetail, bundle)
    }
}