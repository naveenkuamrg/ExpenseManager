package com.example.domain.module.module

data class ExpenseTracker(
    val id: String,
    val amount: Double,
    val note: String,
    val accountId: String,
    val contactId: String?,
    val transactionType: TransactionType
)
