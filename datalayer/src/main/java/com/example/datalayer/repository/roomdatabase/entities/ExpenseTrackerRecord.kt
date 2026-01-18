package com.example.datalayer.repository.roomdatabase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.domain.module.module.ExpenseTracker
import com.example.domain.module.module.PaymentType

@Entity(
    tableName = "expense_tracker_record",
    foreignKeys = [
        ForeignKey(
            entity = AccountRecord::class,
            parentColumns = arrayOf("account_id"),
            childColumns = arrayOf("account_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class ExpenseTrackerRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val note: String,
    @ColumnInfo(name = "account_id")
    val accountId: Long,
    val contactId: Long?,
    val paymentType: Int
)

fun ExpenseTracker.toEntity(): ExpenseTrackerRecord {
    val paymenet_type = when (paymentType) {
        PaymentType.CREDIT -> {
            0
        }

        PaymentType.TRANSFER -> {
            1
        }

        PaymentType.DEBIT -> {
            2
        }
    }

    return if (id.isEmpty()) {
        ExpenseTrackerRecord(
            amount = amount,
            note = note,
            accountId = accountId.toLong(),
            contactId = contactId?.toLong(),
            paymentType = paymenet_type
        )
    } else {
        ExpenseTrackerRecord(
            id = id.toLong(),
            amount = amount,
            note = note,
            accountId = accountId.toLong(),
            contactId = contactId?.toLong(),
            paymentType = paymenet_type
        )
    }
}


fun ExpenseTrackerRecord.toDomain(): ExpenseTracker {
    val paymenet_type = when (paymentType) {
        0 -> {
            PaymentType.CREDIT
        }

        1 -> {
            PaymentType.TRANSFER
        }

        else -> {
            PaymentType.DEBIT
        }
    }
    return ExpenseTracker(
        id.toString(),
        amount,
        note,
        accountId.toString(),
        contactId?.toString(),
        paymenet_type
    )

}