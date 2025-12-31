package com.example.domain.module.usecase

sealed class Result<out T>(val statusCode: Int) {
    class Success<T>(val data: T?, statusCode: Int) : Result<T>(statusCode)
    class Failure(val error: String, statusCode: Int) : Result<Nothing>(statusCode)
}