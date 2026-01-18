package com.example.datalayer.repository.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.datalayer.repository.roomdatabase.entities.AccountRecord

@Dao
interface AccountDAO {
    @Query("Select * from account_record")
    fun getAll(): List<AccountRecord>

    @Query("Select * from account_record WHERE id = (:id)")
    fun getByID(id: Long): AccountRecord

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(accountRecord: AccountRecord): Long

    @Delete
    fun delete(accountRecord: AccountRecord)
}