package com.example.fakestore.data.api

import com.example.fakestore.domain.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApiEndPoint {
    @GET("ds-weapons-api/")
    suspend fun getAllWeapons() : Response<List<Product>>
}