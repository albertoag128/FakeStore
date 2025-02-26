package com.example.fakestore.domain

import com.example.fakestore.utilities.Either
import com.example.fakestore.utilities.AppError

interface ProductRepository {
    suspend fun getAllProducts(): Either<AppError, List<Product>>
    suspend fun getProductById(productId: Int): Either<AppError, Product>
}