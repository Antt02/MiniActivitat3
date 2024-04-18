package com.example.miniactivitat3.network

import retrofit2.http.GET

interface ApiService {
    @GET("bee-movie.txt")
    suspend fun getText(): String
}