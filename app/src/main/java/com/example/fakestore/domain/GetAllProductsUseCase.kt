package com.example.fakestore.domain

import com.example.fakestore.utilities.AppError
import com.example.fakestore.utilities.Either
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Either<AppError, List<Product>> {
        return repository.getAllProducts()
    }
}