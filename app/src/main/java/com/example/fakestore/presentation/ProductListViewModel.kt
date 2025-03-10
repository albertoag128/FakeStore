package com.example.fakestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.domain.GetAllProductsUseCase
import com.example.fakestore.domain.Product
import com.example.fakestore.utilities.AppError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getAllProductUseCase: GetAllProductsUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    fun loadAllProducts() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getAllProductUseCase.invoke().apply {
                _uiState.postValue(
                    UiState(
                        isLoading = false,
                        error = this.swap().getOrNull(),
                        productList = this.getOrNull(),
                    )
                )
            }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val productList: List<Product>? = null,
        val isSuccess: Boolean = false,
        val error: AppError?=null
    )
}