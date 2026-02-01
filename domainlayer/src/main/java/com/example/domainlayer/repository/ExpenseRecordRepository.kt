package com.example.domainlayer.repository

import com.example.domain.module.module.ExpenseTracker
import com.example.domain.module.module.TransactionType
import com.example.domain.module.usecase.Result

interface ExpenseRecordRepository {

    suspend fun create(obj: ExpenseTracker): Result<ExpenseTracker>

    suspend fun get(id: String): Result<ExpenseTracker>
    suspend fun getAll(): Result<List<ExpenseTracker>>

    suspend fun delete(id: String): Result<ExpenseTracker>
    suspend fun updateAmount(id: String, amount: Float): Result<ExpenseTracker>
    suspend fun updateName(id: String, name: String): Result<ExpenseTracker>
    suspend fun updateNote(id: String, note: String): Result<ExpenseTracker>
    suspend fun updateAccount(id: String, accountId: String): Result<ExpenseTracker>
    suspend fun updateContact(id: String, contactId: String): Result<ExpenseTracker>
    suspend fun updatePaymentType(id: String, transactionType: TransactionType): Result<ExpenseTracker>


}