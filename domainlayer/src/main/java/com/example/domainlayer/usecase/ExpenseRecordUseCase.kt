package com.example.domainlayer.usecase

import com.example.domain.module.module.ExpenseRecord
import com.example.domain.module.module.PaymentType
import com.example.domain.module.usecase.BaseUseCase
import com.example.domain.module.usecase.Result
import com.example.domainlayer.repository.ExpenseRecordRepository
import javax.inject.Inject

class ExpenseRecordUseCase @Inject constructor(val repository: ExpenseRecordRepository) :
    BaseUseCase<ExpenseRecord, ExpenseRecordAction>() {
    override suspend fun executeBackground(params: ExpenseRecordAction): Result<ExpenseRecord> {
        return when (params) {
            is ExpenseRecordAction.Get -> {
                repository.get(params.id)
            }
            is ExpenseRecordAction.Create -> {
                var note = params.note
                if(params.note.isNullOrEmpty()) {
                    note = ""
                }
                repository.create(
                    ExpenseRecord(
                        id = "",
                        amount = params.amount,
                        note = note,
                        accountId = params.accountId,
                        contactId = params.contactId,
                        paymentType = params.paymentType
                    )
                )
            }

            is ExpenseRecordAction.Delete -> {
                repository.delete(params.id)
            }

            is ExpenseRecordAction.UpdateAmount -> {
                repository.updateAmount(params.id, params.amount)
            }

            is ExpenseRecordAction.UpdateName -> {
                repository.updateName(params.id, params.name)
            }

            is ExpenseRecordAction.UpdateNote -> {
                var note = params.note
                if(params.note.isNullOrEmpty()) {
                    note = ""
                }
                repository.updateNote(params.id, note)
            }

            is ExpenseRecordAction.UpdateAccount -> {
                repository.updateAccount(params.id, params.accountId)
            }

            is ExpenseRecordAction.UpdateContact -> {
                var contactId = params.contactId
                if(params.contactId.isNullOrEmpty()) {
                    contactId = ""
                }
                repository.updateContact(params.id, contactId)
            }

            is ExpenseRecordAction.UpdatePaymentType -> {
                repository.updatePaymentType(params.id, params.paymentType)
            }
        }
    }
}


sealed class ExpenseRecordAction {
    data class Get(val id: String) : ExpenseRecordAction()
    data class Create(
        val name: String,
        val amount: Int,
        val note: String?,
        val accountId: String,
        val contactId: String?,
        val paymentType: PaymentType
    ) : ExpenseRecordAction()

    data class Delete(val id: String) : ExpenseRecordAction()

    data class UpdateAmount(val id: String, val amount: Float) : ExpenseRecordAction()
    data class UpdateName(val id: String, val name: String) : ExpenseRecordAction()
    data class UpdateNote(val id: String, val note: String?) : ExpenseRecordAction()
    data class UpdateAccount(val id: String, val accountId: String) : ExpenseRecordAction()
    data class UpdateContact(val id: String, val contactId: String?) : ExpenseRecordAction()
    data class UpdatePaymentType(val id: String, val paymentType: PaymentType) :
        ExpenseRecordAction()
}



