package com.example.fakestore.utilities


import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Either<AppError, T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is ConnectException -> AppError.NoInternetAppError.left()
            is UnknownHostException -> AppError.NoInternetAppError.left()
            is SocketTimeoutException -> AppError.TimeOutAppError.left()
            else -> AppError.UnknownAppError.left()
        }
    }
    if (!response.isSuccessful) {
        return AppError.UnknownAppError.left()
    }
    return response.body()!!.right()
}