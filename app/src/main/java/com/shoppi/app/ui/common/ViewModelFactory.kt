package com.shoppi.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.app.AssetLoader
import com.shoppi.app.network.ApiClient
import com.shoppi.app.repository.category.CategoryRemoteDataSource
import com.shoppi.app.repository.category.CategoryRepository
import com.shoppi.app.repository.categorydetail.CategoryDetailRemoteDataSource
import com.shoppi.app.repository.categorydetail.CategoryDetailRepository
import com.shoppi.app.repository.categorydetail.CategoryDetailViewModel
import com.shoppi.app.repository.home.HomeAssetDataSource
import com.shoppi.app.repository.home.HomeRepository
import com.shoppi.app.ui.category.CategoryViewModel
import com.shoppi.app.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
            CategoryViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)){ //카테고리 디테일 뷰 모델이 할당됐는지 확인
            val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create())) //맞다면 레포 클래스 생성
            CategoryDetailViewModel(repository) as T
        } else {
            throw  IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }


}