package com.example.fakestore.data

import com.example.fakestore.domain.Product

interface ProductRemoteDataRepository {
    suspend fun getAllProducts(): List<Product>
}