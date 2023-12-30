package com.shoppi.app.repository.home

import com.shoppi.app.model.HomeData

class HomeRepository (
    private val assetDataSource: HomedataSource
) {
    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }

}