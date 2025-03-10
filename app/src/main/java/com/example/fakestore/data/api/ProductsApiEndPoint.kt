package com.example.fakestore.data.api

import com.example.fakestore.domain.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApiEndPoint {
    @GET("https://api.escuelajs.co/api/v1/products/")
    suspend fun getAllWeapons() : Response<List<Product>>

    @GET("https://api.escuelajs.co/api/v1/products/{id}")
    suspend fun getProductById(@Path("id") id:Int) : Response<Product>
}