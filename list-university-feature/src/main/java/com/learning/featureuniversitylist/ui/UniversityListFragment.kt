package com.learning.featureuniversitylist.ui

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.learning.common.base.BaseFragment
import com.learning.common.base.UiState
import com.learning.common.extensions.configureVerticalList
import com.learning.common.extensions.observeUiState
import com.learning.common.utils.GeneralAdapter
import com.learning.dtos.ui.UniversityView
import com.learning.featureuniversitylist.BR
import com.learning.featureuniversitylist.R
import com.learning.featureuniversitylist.databinding.FragmentUniversityListBinding
import com.learning.featureuniversitylist.navigator.ListNavigator
import com.learning.featureuniversitylist.viewModel.UniversityListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class UniversityListFragment : BaseFragment<FragmentUniversityListBinding>() {

    @Inject
    lateinit var listNavigator: ListNavigator
    private lateinit var viewBinding: FragmentUniversityListBinding
    private val viewModel: UniversityListViewModel by viewModels<UniversityListViewModel>()
    private val adapter =
        GeneralAdapter(BR.university, R.layout.university_item, UniversityView.DIFF_CALLBACK)
    override var shouldBindData: Boolean = true

    companion object {
        fun newInstance() = UniversityListFragment()
    }

    override fun layoutResourceId(): Int {
        return R.layout.fragment_university_list
    }

    override fun initialize(savedInstanceState: Bundle?) {
        viewBinding = binding as FragmentUniversityListBinding
        progressBar = viewBinding.progressBar
        viewBinding.universityRv.configureVerticalList(adapter)
    }

    override fun attachListeners() {
        super.attachListeners()
        adapter.clickListener = { university, view ->
            listNavigator.goToDetail(university)
        }

        viewModel.run {
            fetchUniversities()
            observeUiState {
                uiState.collect { universityListUiState ->
                    when (universityListUiState) {
                        is UiState.Success -> {
                            adapter.submitList(universityListUiState.data.universityList)
                        }

                        is UiState.Error -> {
                            Toast.makeText(
                                context,
                                universityListUiState.errorResponse.Detail,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}