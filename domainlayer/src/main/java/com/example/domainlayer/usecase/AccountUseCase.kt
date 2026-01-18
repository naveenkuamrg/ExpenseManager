package com.example.domain.module.usecase

import com.example.domain.module.module.Account
import com.example.domain.module.repository.AccountRepository
import javax.inject.Inject

class AccountUseCase @Inject constructor(private val repository: AccountRepository) :
    BaseUseCase<Account, AccountUseCaseParams>() {
    override suspend fun executeBackground(params: AccountUseCaseParams): Result<Account> {
        return when (params.requestType) {
            AccountUseCaseParams.GET_RECORD -> {
                params.id ?: return Result.Failure("ID required", 400)
                repository.get(params.id)
            }

            AccountUseCaseParams.DELETE_RECORD -> {
                params.id ?: return Result.Failure("ID required", 400)
                repository.delete(params.id)
            }

            AccountUseCaseParams.UPDATE_RECORD_AMOUNT -> {
                params.id ?: return Result.Failure("ID required", 400)
                params.balance ?: return Result.Failure("Balance required", 400)

                repository.updateBalance(params.id, params.balance)
            }

            AccountUseCaseParams.CREATE_RECORD -> {
                params.name ?: return Result.Failure("Name required", 400)
                repository.create(params.name,params.balance ?: 0.0)
            }

            AccountUseCaseParams.UPDATE_RECORD_NAME -> {
                params.id ?: return Result.Failure("ID required", 400)
                params.name ?: return Result.Failure("Name required", 400)
                repository.updateName(params.id, params.name)
            }

            else -> {
                Result.Failure(error = "not supported operation", 505)
            }
        }
    }
}

data class AccountUseCaseParams(
    val requestType: Int,
    val id: String? = null,
    val name: String? = null,
    val balance: Double? = null
) {
    companion object {
        const val GET_RECORD = 1
        const val GET_ALL_RECORDS = 2
        const val UPDATE_RECORD_NAME = 3
        const val UPDATE_RECORD_AMOUNT = 4
        const val DELETE_RECORD = 5
        const val CREATE_RECORD = 6

    }
}