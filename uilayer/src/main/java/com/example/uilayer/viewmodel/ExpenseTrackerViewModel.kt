package com.example.uilayer.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.module.module.TransactionType
import com.example.domainlayer.usecase.ExpenseRecordAction
import com.example.domainlayer.usecase.ExpenseRecordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseTrackerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val expenseRecordUseCase: ExpenseRecordUseCase
) : ViewModel() {

    val accountId: String? = savedStateHandle["id"]

    fun getExpenseTracker(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRecordUseCase.execute(ExpenseRecordAction.Get(id))
        }
    }

    fun createExpenseTracker(
        amount: Double,
        note: String?,
        accountId: String,
        contactId: String?,
        transactionType: TransactionType
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            expenseRecordUseCase.execute(
                ExpenseRecordAction.Create(
                    amount,
                    note,
                    accountId,
                    contactId,
                    transactionType
                )
            )
        }
    }
}