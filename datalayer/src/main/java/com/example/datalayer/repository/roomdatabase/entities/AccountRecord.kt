package com.example.datalayer.repository.roomdatabase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.domain.module.module.Account


@Entity(tableName = "account_record",)
data class AccountRecord(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,
    val name: String,
    val amount: Double
)

fun Account.toEntity(): AccountRecord = AccountRecord(
    id.toLong(),
    name,
    amount
)

fun AccountRecord.toDomain() : Account = Account(
    id.toString(),
    name,
    amount
)