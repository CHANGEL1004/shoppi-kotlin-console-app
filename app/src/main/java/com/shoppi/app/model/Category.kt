package com.shoppi.app.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id") val categoryId: String,
    val label: String,
    @SerializedName("thumnail_image_url") val thumbnailImageUrl: String,
    val updated: Boolean

)
