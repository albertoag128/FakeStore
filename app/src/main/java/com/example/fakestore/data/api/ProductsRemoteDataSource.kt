package com.example.fakestore.data.api

import com.example.fakestore.data.ProductRemoteDataRepository
import com.example.fakestore.domain.Product
import com.example.fakestore.utilities.AppError
import com.example.fakestore.utilities.Either
import com.example.fakestore.utilities.apiCall
import javax.inject.Inject

class ProductsRemoteDataSource @Inject constructor(
    private val productsApiEndPoint: ProductsApiEndPoint
) : ProductRemoteDataRepository {
    override suspend fun getAllProducts(): Either<AppError, List<Product>> {
        return apiCall {
            productsApiEndPoint.getAllWeapons()
        }
    }

    override suspend fun getProductById(id: Int): Either<AppError, Product> {
        return apiCall {
            productsApiEndPoint.getProductById(id)
        }
    }

}