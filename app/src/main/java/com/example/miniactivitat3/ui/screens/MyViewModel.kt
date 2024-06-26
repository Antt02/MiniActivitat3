package com.example.miniactivitat3.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.miniactivitat3.MyScrapingApplication
import com.example.miniactivitat3.data.MyRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface UiState {
    data class Success(val text: String) : UiState
    object Error : UiState
    object Loading : UiState
}

class MyViewModel(private val myRepository: MyRepository) : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set


    init {
        getText()
    }

    fun getText() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(myRepository.getText())
            } catch (e: IOException) {
                UiState.Error
            } catch (e: HttpException) {
                UiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyScrapingApplication)
                val myRepository = application.container.myRepository
                MyViewModel(myRepository = myRepository)
            }
        }
    }
}
