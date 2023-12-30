package com.shoppi.app.repository.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Promotion
import com.shoppi.app.model.TopSelling
import kotlinx.coroutines.launch

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository // 데이터를 요청해야 하므로 생성자로 레포지를 받는다
): ViewModel()  {
    //레포에서 반환하는 카테리 디테일의 탑셀링과 프로모션 데이타를 그려야하므로 변수에 저장하자
    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling : LiveData<TopSelling> =_topSelling

    private val _promotion = MutableLiveData<Promotion>()
    val promotion : LiveData<Promotion> = _promotion
    init{
        loadCategoryDetail()
    }
    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotion.value = categoryDetail.promotions
        }
    }
}