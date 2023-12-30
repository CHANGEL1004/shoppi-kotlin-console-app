package com.shoppi.app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Category
import com.shoppi.app.repository.category.CategoryRepository
import com.shoppi.app.ui.common.Event
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: LiveData<List<Category>> = _items

    init{
        loadCategory()
    }
    //아이템이 선택 되었는지 여부를 저장하는 데이터
    private val _openCategoryEvent = MutableLiveData<Event<Category>>()
    val openCategoryEvent: LiveData<Event<Category>> = _openCategoryEvent

    fun openCategoryDetail(category: Category){
        _openCategoryEvent.value = Event(category)
    }

    private fun loadCategory(){
        viewModelScope.launch {
            val categories =  categoryRepository.getCategories()
            _items.value = categories //에이피아이 통해 받아온 데이터들을 아이템즈의 밸류에 할당
        } // 카테고리 리스트 반환

    }
}