package com.shoppi.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.app.model.Banner
import com.shoppi.app.model.Title
import com.shoppi.app.repository.home.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository):ViewModel() {

    private val _title = MutableLiveData<Title>() //외부에서 접근하지 못 하는 변수 명 앞에 _ 붙이는 컨벤션
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners
    init {
        loadHomeData()
    }
    private fun loadHomeData(){
        val homeData = homeRepository.getHomeData()
        homeData?.let{ homeData ->
            _title.value = homeData.title
            _topBanners.value = homeData.topBanners
        }

    }
}