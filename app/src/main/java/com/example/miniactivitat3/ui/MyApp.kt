package com.example.miniactivitat3.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.miniactivitat3.ui.screens.MainScreen
import com.example.miniactivitat3.ui.screens.MyViewModel

@Composable
fun MyApp() {
    Scaffold(){ scaffoldPadding->
        Log.i("Padding", scaffoldPadding.toString())
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val mViewModel: MyViewModel =
                viewModel(factory = MyViewModel.Factory)
            MainScreen(uiState = mViewModel.uiState, retryAction = mViewModel::getText)
        }
    }
}
