package com.example.domain.module.repository

import com.example.domain.module.module.Account
import com.example.domain.module.usecase.Result


interface AccountRepository {

    suspend fun create(name: String, amount: Double): Result<Account>

    suspend fun get(id: String): Result<Account>

    suspend fun updateName(id: String, name: String): Result<Account>

    suspend fun updateBalance(id: String, amount: Double): Result<Account>

    suspend fun delete(id: String): Result<Account>

    suspend fun getAllAccounts(): Result<List<Account>>
}
