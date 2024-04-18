package com.example.miniactivitat3

import android.app.Application
import com.example.miniactivitat3.data.AppContainer
import com.example.miniactivitat3.data.DefaultAppContainer

class MyScrapingApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}