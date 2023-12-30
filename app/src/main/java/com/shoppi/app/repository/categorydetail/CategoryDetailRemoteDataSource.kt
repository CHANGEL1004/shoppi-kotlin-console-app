package com.shoppi.app.repository.categorydetail

import com.shoppi.app.model.CategoryDetail
import com.shoppi.app.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getcategoryDetail(): CategoryDetail {
        return api.getCategoriesDetail() //api의 데이터를 요청, 이제 이 데이터 소스를 호출하는 레포지토리 클래스를 만들어야함
    }
}