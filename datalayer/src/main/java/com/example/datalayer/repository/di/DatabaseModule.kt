package com.example.datalayer.repository.di

import android.content.Context
import androidx.room.Room
import com.example.datalayer.repository.roomdatabase.AppDatabase
import com.example.datalayer.repository.roomdatabase.dao.AccountDAO
import com.example.datalayer.repository.roomdatabase.dao.ExpenseTrackerDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()


    @Provides
    fun provideAccountDao(db: AppDatabase): AccountDAO = db.accountDao()


    @Provides
    fun provideExpenseTrackerDAO(db: AppDatabase): ExpenseTrackerDAO = db.expenseTrackerRecordDao()
}
