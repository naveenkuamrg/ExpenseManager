package com.example.domain.module.module

data class ExpenseRecord(
    val id: String,
    val amount: Int,
    val note: String,
    val accountId: String,
    val contactId: String?,
    val paymentType: PaymentType
)
