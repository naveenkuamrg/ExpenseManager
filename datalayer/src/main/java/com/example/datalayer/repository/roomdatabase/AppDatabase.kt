package com.example.datalayer.repository.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datalayer.repository.roomdatabase.dao.AccountDAO
import com.example.datalayer.repository.roomdatabase.dao.ExpenseTrackerDAO
import com.example.datalayer.repository.roomdatabase.entities.AccountRecord
import com.example.datalayer.repository.roomdatabase.entities.ExpenseTrackerRecord

@Database(
    entities = [AccountRecord::class, ExpenseTrackerRecord::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDAO
    abstract fun expenseTrackerRecordDao(): ExpenseTrackerDAO

}