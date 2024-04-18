package com.example.miniactivitat3.data


import com.example.miniactivitat3.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

interface AppContainer {
    val myRepository: MyRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://courses.cs.washington.edu/courses/cse163/20wi/files/lectures/L04/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }


    override val myRepository: MyRepository by lazy {
        NetworkMyRepository(retrofitService)
    }

}
