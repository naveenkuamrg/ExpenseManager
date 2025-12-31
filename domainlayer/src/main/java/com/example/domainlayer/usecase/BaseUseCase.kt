package com.example.domain.module.usecase

abstract class BaseUseCase<T,K> {

    suspend fun execute(params: K): Result<T> {
        return try {
            executeBackground(params)
        } catch (e: Exception) {
            Result.Failure(e.message ?: "Unknown error", 500)
        }
    }
    protected abstract suspend fun executeBackground(params: K): Result<T>
}