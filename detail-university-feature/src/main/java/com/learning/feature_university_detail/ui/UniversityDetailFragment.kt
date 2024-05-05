package com.learning.feature_university_detail.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.learning.common.base.BaseFragment
import com.learning.dtos.ui.UniversityView
import com.learning.feature_university_detail.R
import com.learning.feature_university_detail.databinding.FragmentUniversityDetailBinding
import com.learning.feature_university_detail.navigator.DetailNavigator
import com.learning.feature_university_detail.viewModel.UniversityDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UniversityDetailFragment : BaseFragment<FragmentUniversityDetailBinding>() {

    @Inject
    lateinit var detailNavigator: DetailNavigator
    private lateinit var viewBinding: FragmentUniversityDetailBinding
    override var shouldBindData: Boolean = true
//    private val args: UniversityDetailFragmentArgs by navArgs()

    companion object {
        fun newInstance() = UniversityDetailFragment()
    }

    override fun layoutResourceId(): Int = R.layout.fragment_university_detail

    override fun initialize(savedInstanceState: Bundle?) {
        viewBinding = binding as FragmentUniversityDetailBinding
        val uniDetails = arguments?.getParcelable<UniversityView>("uni-detail")!!
        viewBinding.apply {
            name.text = uniDetails.name
            uniState.text = uniDetails.state
            countryCode.text = uniDetails.countryCode
            country.text = uniDetails.country
        }
    }

    override fun attachListeners() {
        super.attachListeners()
        viewBinding.refreshImage.setOnClickListener {
            detailNavigator.backToList()
        }
    }
}