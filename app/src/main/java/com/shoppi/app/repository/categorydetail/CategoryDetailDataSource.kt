package com.shoppi.app.repository.categorydetail

import com.shoppi.app.model.CategoryDetail

interface CategoryDetailDataSource {
    //이 인터페이스를 구현하는 데이터 소스를 만들고, 이 데이터 소스에게 레포지스토리 클래스가 데이터를 요청하는 방식으로 구현

    suspend fun getcategoryDetail(): CategoryDetail
}