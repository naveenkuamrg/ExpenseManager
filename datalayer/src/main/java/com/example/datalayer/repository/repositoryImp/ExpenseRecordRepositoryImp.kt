package com.example.datalayer.repository.repositoryImp

import com.example.domain.module.module.ExpenseRecord
import com.example.domain.module.module.PaymentType
import com.example.domain.module.usecase.Result
import com.example.domainlayer.repository.ExpenseRecordRepository

class ExpenseRecordRepositoryImp: ExpenseRecordRepository {
    override suspend fun create(obj: ExpenseRecord): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: String): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updateAmount(
        id: String,
        amount: Float
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updateName(
        id: String,
        name: String
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(
        id: String,
        note: String
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updateAccount(
        id: String,
        accountId: String
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updateContact(
        id: String,
        contactId: String
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }

    override suspend fun updatePaymentType(
        id: String,
        paymentType: PaymentType
    ): Result<ExpenseRecord> {
        TODO("Not yet implemented")
    }
}