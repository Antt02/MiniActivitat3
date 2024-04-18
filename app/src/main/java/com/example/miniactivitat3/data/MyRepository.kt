package com.example.miniactivitat3.data

import com.example.miniactivitat3.network.ApiService

interface MyRepository {
    suspend fun getText(): String
}

class NetworkMyRepository(private val apiService: ApiService) : MyRepository {
    override suspend fun getText(): String {
        return apiService.getText()
    }
}