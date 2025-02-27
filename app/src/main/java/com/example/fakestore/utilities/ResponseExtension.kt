package com.example.fakestore.utilities

import okhttp3.Response
import java.net.SocketTimeoutException

suspend fun apiCall(call: suspend () -> Response): Either<AppError, Any> {
    val response: Response
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is SocketTimeoutException -> AppError.TimeOutAppError.left()
            else -> AppError.UnknownAppError.left()
        }
    }
    if (!response.isSuccessful) {
        return AppError.UnknownAppError.left()
    }
    return response.body()!!.right()
}