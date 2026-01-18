package com.example.datalayer.repository.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.datalayer.repository.roomdatabase.entities.ExpenseTrackerRecord

@Dao
interface ExpenseTrackerDAO {

    @Query("Select * from expense_tracker_record")
    fun getAll(): List<ExpenseTrackerRecord>

    @Query("select * from expense_tracker_record where id = (:id)")
    fun getByID(id: Long): ExpenseTrackerRecord

    @Insert
    fun insert(record: ExpenseTrackerRecord)

    @Delete
    fun delete(record: ExpenseTrackerRecord)

    @Update
    suspend fun updateRecord(record: ExpenseTrackerRecord)

    @Query("UPDATE expense_tracker_record SET amount = (:amount) WHERE id = (:id)")
    suspend fun updateRecordAmountByID(id: Double, amount: Double)


}