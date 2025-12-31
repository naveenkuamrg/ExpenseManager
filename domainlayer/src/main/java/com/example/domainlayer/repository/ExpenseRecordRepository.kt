package com.example.domainlayer.repository

import com.example.domain.module.module.Account
import com.example.domain.module.module.Contact
import com.example.domain.module.module.ExpenseRecord
import com.example.domain.module.module.PaymentType
import com.example.domain.module.usecase.Result
import com.example.domainlayer.usecase.ExpenseRecordAction

interface ExpenseRecordRepository {

    suspend fun create(obj: ExpenseRecord): Result<ExpenseRecord>

    suspend fun get(id: String): Result<ExpenseRecord>

    suspend fun delete(id: String): Result<ExpenseRecord>
    suspend fun updateAmount(id: String, amount: Float): Result<ExpenseRecord>
    suspend fun updateName(id: String, name: String): Result<ExpenseRecord>
    suspend fun updateNote(id: String, note: String): Result<ExpenseRecord>
    suspend fun updateAccount(id: String, accountId: String): Result<ExpenseRecord>
    suspend fun updateContact(id: String, contactId: String): Result<ExpenseRecord>
    suspend fun updatePaymentType(id: String, paymentType: PaymentType): Result<ExpenseRecord>


}