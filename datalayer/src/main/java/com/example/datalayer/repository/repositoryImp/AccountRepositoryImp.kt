package com.example.datalayer.repository.repositoryImp

import com.example.domain.module.module.Account
import com.example.domain.module.repository.AccountRepository
import com.example.domain.module.usecase.Result
import javax.inject.Inject

class AccountRepositoryImp @Inject  constructor(): AccountRepository {
    override suspend fun create(name: String): Result<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: String): Result<Account> {
        return Result.Success<Account>(data = Account(id = "1", name = "account", amount = 0f), 200)
    }

    override suspend fun updateName(
        id: String,
        name: String
    ): Result<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun updateBalance(
        id: String,
        amount: Int
    ): Result<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Result<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAccounts(): Result<List<Account>> {
        TODO("Not yet implemented")
    }

}