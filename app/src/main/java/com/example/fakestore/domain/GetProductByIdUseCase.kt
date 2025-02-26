package com.example.fakestore.domain

import com.example.fakestore.utilities.AppError
import com.example.fakestore.utilities.Either
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: Int): Either<AppError,Product> {
        return repository.getProductById(productId)
    }
}