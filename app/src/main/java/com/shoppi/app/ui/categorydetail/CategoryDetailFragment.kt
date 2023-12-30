package com.shoppi.app.ui.categorydetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.shoppi.app.R
import com.shoppi.app.common.KEY_CATEGORY_ID
import com.shoppi.app.common.KEY_CATEGORY_LABEL
import com.shoppi.app.databinding.FragmentCategoryDetailBinding
import com.shoppi.app.repository.categorydetail.CategoryDetailViewModel
import com.shoppi.app.ui.category.CategoryPromotionAdapter
import com.shoppi.app.ui.category.CategoryViewModel
import com.shoppi.app.ui.common.ViewModelFactory

class CategoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels {ViewModelFactory(requireContext())} //이제 뷰모델에 저장한 데이터 사용가능

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()

    }


    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter() {

        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = CategorySectionTitleAdapter()
        val promotionAdapter = CategoryPromotionAdapter()

        binding.rvCategoryDetail.adapter = ConcatAdapter(topSellingSectionAdapter, titleAdapter, promotionAdapter)
        viewModel.topSelling.observe(viewLifecycleOwner) {topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }
        viewModel.promotion.observe(viewLifecycleOwner) {promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }
}