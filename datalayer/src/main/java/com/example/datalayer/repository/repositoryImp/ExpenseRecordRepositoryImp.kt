package com.example.datalayer.repository.repositoryImp

import com.example.datalayer.repository.ResultWrapper
import com.example.datalayer.repository.roomdatabase.dao.ExpenseTrackerDAO
import com.example.datalayer.repository.roomdatabase.entities.toDomain
import com.example.datalayer.repository.roomdatabase.entities.toEntity
import com.example.domain.module.module.ExpenseTracker
import com.example.domain.module.module.TransactionType
import com.example.domain.module.usecase.Result
import com.example.domainlayer.repository.ExpenseRecordRepository
import javax.inject.Inject

class ExpenseRecordRepositoryImp @Inject constructor(val expenseTrackerDAO: ExpenseTrackerDAO) :
    ExpenseRecordRepository {
    override suspend fun create(obj: ExpenseTracker): Result<ExpenseTracker> {
        return ResultWrapper.wrap(
            "Create Expense record failed",
            500,
            {
                expenseTrackerDAO.insert(
                    obj.toEntity()
                )
                Result.Success<ExpenseTracker>(null, 200)
            }
        )
    }

    override suspend fun get(id: String): Result<ExpenseTracker> {
        return ResultWrapper.wrap(
            "Fetching Expense record failed", 500,
            {
                Result.Success<ExpenseTracker>(
                    expenseTrackerDAO.getByID(id.toLong()).toDomain(),
                    200
                )
            }
        )
    }

    override suspend fun getAll(): Result<List<ExpenseTracker>> {
        return ResultWrapper.wrap(
            "Failed to fetch all Expense record ", 500,
            {
                Result.Success<List<ExpenseTracker>>(
                    expenseTrackerDAO.getAll().map { it.toDomain() },
                    200
                )
            }
        )
    }

    override suspend fun delete(id: String): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updateAmount(
        id: String,
        amount: Float
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updateName(
        id: String,
        name: String
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(
        id: String,
        note: String
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updateAccount(
        id: String,
        accountId: String
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updateContact(
        id: String,
        contactId: String
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePaymentType(
        id: String,
        transactionType: TransactionType
    ): Result<ExpenseTracker> {
        TODO("Not yet implemented")
    }
}