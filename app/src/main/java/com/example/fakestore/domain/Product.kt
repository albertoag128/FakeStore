package com.example.fakestore.domain

data class Product(
    val id: Int?,
    val title: String?,
    val slug: String?,
    val price: Int?,
    val description: String?,
    val productCategory: ProductCategory?,
    val images: ArrayList<String>,
    val creationAt: String?,
    val updatedAt: String?
)