package com.shoppi.app.network

import com.shoppi.app.model.Category
import com.shoppi.app.model.CategoryDetail
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("categories.json")
    suspend fun getCategories(): List<Category>
    /*@GET("@{categoryId}.json")
    suspend fun getCategoriesDetail(@Path("categoryId") categoryId: String): CategoryDetail*/
    @GET("fashion_femail.json")
    suspend fun getCategoriesDetail(): CategoryDetail

    companion object{

        private const val baseUrl = "https://shoppi-1e9a1-default-rtdb.asia-southeast1.firebasedatabase.app/categories"
        fun create(): ApiClient{
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC //로그 레벨을 베이직으로 설정,
            }

            val client = OkHttpClient.Builder() //빌더 통해 클라이언트 생성
                .addInterceptor(logger) //메세지의 포맷, 인터셉터 정의 통해 변경, 로거를 인터셉터에 전달하고
                .build() //빌드 통해 클라이언트 생성

            return Retrofit.Builder()
                .baseUrl("baseUrl")
                .client(client) //클라이언트로 전달
                .addConverterFactory(GsonConverterFactory.create()) //http 응답의 결과를 프로젝트에서 사용하는 객체로 변환
                .build()
                .create(ApiClient::class.java)
        }
    }
}