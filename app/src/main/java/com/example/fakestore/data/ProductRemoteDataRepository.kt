package com.example.fakestore.data

import com.example.fakestore.domain.Product
import com.example.fakestore.utilities.AppError
import com.example.fakestore.utilities.Either

interface ProductRemoteDataRepository {
    suspend fun getAllProducts(): Either<AppError, List<Product>>
    suspend fun getProductById(id: Int): Either<AppError, Product>
}