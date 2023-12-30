package com.shoppi.app.repository.categorydetail

import com.shoppi.app.model.CategoryDetail

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getcategoryDetail() //요걸 뷰모델에서 호출하면 되겠죠?
    }
}