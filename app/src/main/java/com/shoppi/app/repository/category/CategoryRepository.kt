package com.shoppi.app.repository.category

import com.shoppi.app.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository (
    private val remoteDataSource: CategoryRemoteDataSource
) {

    suspend fun getCategories(): List<Category> {
        withContext(Dispatchers.IO){
            remoteDataSource.getCategories()
        }
        return remoteDataSource.getCategories()
    }

}