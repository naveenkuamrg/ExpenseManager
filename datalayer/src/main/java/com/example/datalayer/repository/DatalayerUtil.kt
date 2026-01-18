package com.example.datalayer.repository

import com.example.domain.module.usecase.Result

object ResultWrapper {
    inline fun <T> wrap(
        errorMessage: String,
        statusCode: Int,
        block: () -> Result<T>
    ): Result<T> =
        try {
            block()
        } catch (e: Exception) {
            Result.Failure(errorMessage, statusCode)
        }
}
