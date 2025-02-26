package com.example.fakestore.utilities

sealed class AppError {
    data object DataAppError : AppError()
    data object UnknownAppError : AppError()
    data object NoInternetAppError : AppError()
    data object TimeOutAppError : AppError()
}