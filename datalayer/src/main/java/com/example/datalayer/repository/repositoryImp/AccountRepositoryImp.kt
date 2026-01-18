package com.example.datalayer.repository.repositoryImp

import com.example.datalayer.repository.ResultWrapper
import com.example.datalayer.repository.roomdatabase.dao.AccountDAO
import com.example.datalayer.repository.roomdatabase.entities.AccountRecord
import com.example.datalayer.repository.roomdatabase.entities.toDomain
import com.example.domain.module.module.Account
import com.example.domain.module.repository.AccountRepository
import com.example.domain.module.usecase.Result
import javax.inject.Inject

class AccountRepositoryImp @Inject constructor(val accountDAO: AccountDAO) : AccountRepository {
    override suspend fun create(name: String, amount: Double): Result<Account> {
        return ResultWrapper.wrap(
            "Create Account failed", 500,
            {
                accountDAO.insert(
                    AccountRecord(
                        name = name,
                        amount = amount,
                    )
                )
                Result.Success<Account>(data = null, 400)
            }
        )

    }

    override suspend fun get(id: String): Result<Account> {
        return ResultWrapper.wrap(
            "Get a account failed",
            501,
            {
                Result.Success<Account>(
                    accountDAO.getByID(id.toLong()).toDomain(),
                    200
                )
            }
        )
    }

    override suspend fun updateName(
        id: String,
        name: String
    ): Result<Account> {
        TODO("Not yet implemented")
    }

    override suspend fun updateBalance(
        id: String,
        amount: Double
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